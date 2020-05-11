package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;
/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
            }
        size = 0;
        }

    public void save(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.getUuid() == null) {
                System.out.println("Сохранить невозможно, одинаковые значения");
            } else {
                storage[size-i] = resume;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].getUuid() == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++){
            if(storage[i].getUuid() == uuid) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[10_000];
         for(int i = 0; i<size; i++) {
             resumes[i] = storage[i];
         }
        return resumes;
    }

    public int size() {
        return size;
    }
}


