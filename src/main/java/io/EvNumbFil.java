package io;

import java.io.FileInputStream;

public class EvNumbFil {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                sb.append((char) read);
            }
            String[] arr = sb.toString().split(System.lineSeparator());
            for (String el : arr) {
                int a = Integer.parseInt(el);
                if (a % 2 == 0)
                    System.out.println(a + " четное");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
