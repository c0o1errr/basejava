package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;


    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override // тоже самое что и в doSave только не создавать файл
    protected void doUpdate(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("File write error", r.getUuid(), e);
        }
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("Couldn't create file" + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);

    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    /*@Override
    protected File getSearchkey(String uuid) {
        return new File(directory, uuid);
    }*/

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override // создать абстрактый методо doRead который читает
    protected Resume doGet(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override //читает все файлы которые есть в коталоге и doRead читает
    protected List<Resume> doCopyAll() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", null);
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(doGet(file));
        }
        return null;
    }

    @Override // получить все файлы и удалить методом delete
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    doRead(file);
                } catch (IOException e) {
                    throw new StorageException("File read error", file.getName(), e);
                }
            }
        }
    }

    @Override // посчитать количество файлов
    public int size() {
        String[] list = directory.list();
        if (list == null) {
            throw new StorageException("Directory not be read", null);
        }
        return list.length;
    }
}
