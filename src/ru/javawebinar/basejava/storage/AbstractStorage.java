package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Objects;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object searchKey =  getSearchKey(r.getUuid());
        if (Objects.isNull(searchKey)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateElement(searchKey, r);
        }
    }


    public void save(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (Objects.isNull(searchKey)) {
            throw new ExistStorageException(r.getUuid());
        }
        saveElement(searchKey, r);
    }


    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (Objects.isNull(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(searchKey);
        }
    }


    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (Objects.isNull(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(searchKey);
    }

    protected abstract Resume getElement(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract void updateElement(Object searchKey, Resume r);

    protected abstract void saveElement(Object searchKey, Resume r);

    protected abstract void deleteElement(Object searchKey);
}
