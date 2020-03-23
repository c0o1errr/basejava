/**
 * Array based storage for Resumes
 */

public class ArrayStorage<delete> {
    Resume[] storage = new Resume[10000];
    private String uuid;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {

    }

    Resume get(String uuid) {
                for (int i = 0; i < storage.length; i++) {
                    if(storage[i].uuid == uuid) {
                        return storage[i];
                    }
                }
                return null;

    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            storage[i].uuid = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[10000];
        for (int i = 0; i < storage.length; i++){
            storage[i] = newStorage[i];
        }
        return newStorage;
    }

    int size() {
        for (int i = 0; i < storage.length; i++){
            // если считать, что массив отсортирован, но это не точно :'(
            if (storage[i] == null) {
                System.out.println("Длина массива = " + (i - 1));
            }
        }
        return 0;
    }
}
