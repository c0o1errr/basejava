package com.basejava.webapp;

import com.basejava.webapp.model.SectionType;

public class TestSingleton {
    private static TestSingleton instance = new TestSingleton();

    public static TestSingleton getInstance() {
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        Singleton chto = Singleton.valueOf("CHTO");
        System.out.println(instance.toString() + " " + chto.ordinal() + " " + chto.name());
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

    private enum Singleton {
        INSTANCE, CHTO
    }
}
