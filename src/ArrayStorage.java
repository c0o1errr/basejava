/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10_000];
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    private void setUuid (String uuid) {
        this.uuid = uuid;
    }

    private void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    private void save(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(null)) {
                storage[i] = resume;
            } else if (storage[i].equals(resume)) {
                System.out.println("Сохранить невозможно, одинаковые значения");
            }
        }
    }

    private Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    private void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(null)) {
                storage[i].uuid = storage[i+1].uuid;
            } else {
                storage[i].uuid = storage[i].uuid;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    private Resume[] getAll() {
        Resume[] newStorage = new Resume[10_000];
        for (int i = 0; i < storage.length; i++){
            storage[i] = newStorage[i];
        }
        return newStorage;
    }

    private int size() {
         int longStorage = 0;
         for (int i = 0; i < storage.length; i++) {
             if (storage[i].equals(null)) {
                 longStorage = i + 1;
             }
         }
        return longStorage;
    }
}
