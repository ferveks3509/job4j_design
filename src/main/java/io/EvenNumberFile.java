package io;

import java.io.FileInputStream;
import java.sql.SQLOutput;

public class EvenNumberFile {
    public static void main(String[] args) {
       try (FileInputStream in = new FileInputStream("even.txt")){
           StringBuilder text = new StringBuilder();
           int res;
           while ((res = in.read()) != -1) {
               text.append((char) res);
           }
           System.out.println(text);
           System.out.println();

           String[] str = text.toString().split(System.lineSeparator());
           for (String el : str) {
               if (Integer.parseInt(el) % 2 == 0) {
                   System.out.println(el + " четное");
               } else {
                   System.out.println(el + " нечетное");
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
