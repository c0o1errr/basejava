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
        int count = 0;
        for (int i = 0; i < storage.length; i++){
            if(storage[i].getUuid() != uuid){
                count++;
            } else if (storage[i] == null) {
                System.out.println("Пустое значение");
            } else {
                storage[i-count] = storage[i];;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
     Resume[] getAll() {
        Resume[] newStorage = new Resume[10_000];
         int count = 0;
         for (int i = 0; i < storage.length; i++){
             if (newStorage[i] == null) {
                 count++;
             } else {
                 newStorage[i-count] = newStorage[i];
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
