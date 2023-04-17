package io.files;

import java.io.File;
import java.util.Arrays;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not dir %s", file.getAbsoluteFile()));
        }
        System.out.printf("size: %s", file.getTotalSpace());
        for (File subFile : file.listFiles()) {
            System.out.printf("file name: %s  file size: %s%n",subFile.getName(), file.length());
        }
    }
}
