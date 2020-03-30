/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10_000];

     void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

     void save(Resume resume) {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                size = size + 1;
                return;
            } else if (storage[i] == resume) {
                System.out.println("Сохранить невозможно, одинаковые значения");
            }
        }
    }

     Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i].getUuid() == uuid) {
                return storage[i];
            }
        }
        return null;
    }

     void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = storage[i+1];
            } else {
                storage[i] = storage[i];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
     Resume[] getAll() {
        Resume[] newStorage = new Resume[10_000];
        for (int i = 0; i < storage.length; i++){
            storage[i] = newStorage[i];
        }
        return newStorage;
    }

     int size() {
         int longStorage = 0;
         for (int i = 0; i < storage.length; i++) {
             if (storage[i] == null) {
                 longStorage = i + 1;
             }
         }
        return longStorage;
    }
}
