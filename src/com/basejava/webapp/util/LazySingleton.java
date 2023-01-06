package com.basejava.webapp.util;

public class LazySingleton {
    volatile static /*final*/ LazySingleton INSTANCE; // = new LazySingleton();

    private LazySingleton() {}

    public static LazySingleton getInstance() { //ленивый синглетон объявляется не сразу, а внутри getInstance
        if(INSTANCE == null) {
            synchronized (LazySingleton.class) {      // double-check locked, чтобы Instance был равен null
                if(INSTANCE == null) {                // при многопоточности и никто не присвоил уже
                    INSTANCE = new LazySingleton();
                }
            }

            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
