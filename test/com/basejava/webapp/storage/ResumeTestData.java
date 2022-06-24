package com.basejava.webapp.storage;

import com.basejava.webapp.model.SectionType;
import com.basejava.webapp.model.TextSection;

public class ResumeTestData extends AbstractStorageTest{

    public ResumeTestData(Storage storage) {
        super(storage);
    }

    static {
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1")); // 13-21 time contined...

    }
}
