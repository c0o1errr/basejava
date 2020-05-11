/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                return;
            }
        }
    }

    public void save(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
            } else if (storage[i] == resume) {                      // else if (storage[i] == resume) сравнивать нужно uuid, а не резюме целиком
                System.out.println("Сохранить невозможно, одинаковые значения");
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i].getUuid() == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
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
    public Resume[] getAll() {
        Resume[] resumes = new Resume[10_000];
         int count = 0;
         for (int i = 0; i < storage.length; i++){
             if (resumes[i] == null) {
                 count++;
             } else {
                 resumes[i-count] = resumes[i];
             }
         }
        return resumes;
    }

    public int size() {
        return size;
    }
}
