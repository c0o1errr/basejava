package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.io.*;

public class ObjectStreamStorage extends AbstractFileStorage{

    @Override
    protected void doWrite(Resume r, OutputStream file) throws IOException {
        
    }

    @Override
    protected Resume doRead(InputStream file) throws IOException {
        return null;
    }

    protected ObjectStreamStorage(File directory) {
        super(directory);
    }
}
