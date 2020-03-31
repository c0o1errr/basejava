import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10_000];

     void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                return;
            }
        }
    }

     void save(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
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
         Arrays.sort(storage);
        for (int i = 0; i < storage.length; i++){
            if (storage[i] == null) {
                newStorage[i] = storage[i-1];
            }
        }
        return newStorage;
    }

     int size() {
         int size = storage.length;
         int longStorage = 0;
         for (int i = 0; i < size; i++) {
             if (storage[i] == null) {
                 longStorage = i - 1;
             }
         }
        return longStorage;
    }
}
