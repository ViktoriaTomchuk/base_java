package ru.javawebinar.basejava.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\gitignore";
//        printAllFiles(new File("C:\\Users\\HP\\IdeaProjects\\base_java"));

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File(".\\src\\ru\\javawebinar\\basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
                printDirectoryDeeply(dir, "");
    }

    public static void printDirectoryDeeply(File dir, String offset) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(offset + "Directory: " + file.getName());
                    printDirectoryDeeply(file, offset + "  ");
                }
            }
        }

    }
}

//    TODO те, що я виконала на домашку(рекурсія)

//    public static void printAllFiles(File dir) {
//        for (File file : dir.listFiles()) {
//            if (file.isDirectory())
//                printAllFiles(file);
//            else
//                System.out.println(file.getAbsolutePath());


