package com.basejava.webapp.exception;

public class gExistStorageException extends StorageException{
    public ExistStorageException( String uuid) {
        super( "Resume " + uuid + " already exist", uuid);
    }
}
