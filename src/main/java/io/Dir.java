package io;

import org.w3c.dom.ls.LSOutput;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File(String.format("c:\\users"));
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
