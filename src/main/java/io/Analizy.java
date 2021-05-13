package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public List<String> unavailable(String source) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            boolean flag = false;
            while ((line = in.readLine()) != null) {
                String status = line.split(" ")[0];
                String time = line.split(" ")[1];
                if (status.contains("400") || status.contains("500")) {
                    rsl.add(time + ";");
                    flag = true;
                }
                if (status.contains("200") || status.contains("300")) {
                    rsl.add(time + System.lineSeparator());
                    flag = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }
    public void save(List<String> list, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String el : list) {
                out.println(el);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}