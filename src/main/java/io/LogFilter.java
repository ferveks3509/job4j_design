package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] spl = line.split(" ");
                if (spl[spl.length - 2].contains("404")) {
                    rsl.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> list, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            for (String el : list) {
                out.println(el);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("data/log.txt");
        save(log, "404.txt");
    }
}
