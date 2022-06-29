package com.basejava.webapp;

import javax.management.RuntimeErrorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\basejava\\.gitignore");
        System.out.println(file.getCanonicalPath());
        File dir = new File(".\\src\\com\\basejava\\webapp");
        System.out.println(dir.isDirectory());
        for (String name : dir.list()) {
            System.out.println(name);
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        printDirectoryDeeply(dir);

    }


    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }
}
