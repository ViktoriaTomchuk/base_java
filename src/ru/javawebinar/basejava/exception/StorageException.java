package ru.javawebinar.basejava.exception;

public class StorageException extends RuntimeException {
    private final String uuid;


    //    Додала самостійно, щоб уникнути помилок в інших файлах
    public StorageException(String message, Object o) {
        this(message, null, null);
    }

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String message, Exception e) {
        this(message, null, e);
    }

    public StorageException(String message, String uuid, Exception e) {
        super(message, e);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
