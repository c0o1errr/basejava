package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if(!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if(!directory.canRead() || !directory.canWrite()) {
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
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error",  file.getName(), e);
        }

    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    @Override
    protected File getSearchkey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doDelete(File file) {
        file.delete();
    }

    protected abstract void doRead (File file);

    @Override // создать абстрактый методо doRead который читает
    protected Resume doGet(File file) {
        return null;

    }

    @Override //читает все файлы которые есть в коталоге и doRead читает
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override // получить все файлы и удалить методом delete
    public void clear() {
        doRead(file);

    }

    @Override // посчитать количество файлов
    public int size() {
        return 0;
    }
}
