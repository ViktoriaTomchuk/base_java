package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }

    }

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            Arrays.copyOfRange(storage, getIndex(r.getUuid()), size);
            storage[getIndex(r.getUuid())] = r;
            size++;


//            storage[size] = r;
//            size++;
//            for (int k = 1; k < STORAGE_LIMIT; k++) {
//                Resume newElement = storage[k];
//                int index = Arrays.binarySearch(storage, 0, k, newElement);
//                if (index < 0) {
//                    index = -(index) - 1;
//                }
//                System.arraycopy(storage, index, storage, index + 1, k - index);
//                storage[index] = newElement;
        }
    }


    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            Arrays.copyOfRange(storage, getIndex(uuid), size--);
            storage[getIndex(uuid)] = storage[getIndex(uuid) - 1];
            storage[getIndex(uuid) - 1] = null;
            size--;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
//        Resume searchKey = new Resume();
//        searchKey.setUuid(uuid);
//        return Arrays.binarySearch(storage, 0, size, searchKey);

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().compareTo(uuid) > 0) {
                return i;
            }
            return size;
        }
    }
}

