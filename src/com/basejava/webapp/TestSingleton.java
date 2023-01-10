package com.basejava.webapp;

import com.basejava.webapp.model.SectionType;

import static com.basejava.webapp.model.SectionType.EXPERIENCE;

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
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
        //System.out.println(CONTACTS.getTitle() + " 9992093969");
    }

    private enum Singleton {
        INSTANCE
    }
}
