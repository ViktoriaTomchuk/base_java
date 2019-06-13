import java.util.Arrays;
import java.util.Objects;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i<size; i++){
            storage[i]= null;
        }
        size=0;
    }

    void save(Resume r) {
        if (Objects.isNull(r)) return;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                return;
            }
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage){
            if (resume.equals(uuid)){
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i=0; i<size;i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size-1];
                storage[size-1]=null;
                size--;
            }
        }


    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i=0; i<size;i++){
            result[i]= storage[i];
        }
        return result;
    }

    int size() {
        return size;
    }
}
