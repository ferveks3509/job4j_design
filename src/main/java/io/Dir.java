package io;

import org.w3c.dom.ls.LSOutput;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist", file.getAbsolutePath()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory", file.getAbsolutePath()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File el : file.listFiles()) {
            System.out.println(el.getName() + " " + el.length());
        }
    }
}
