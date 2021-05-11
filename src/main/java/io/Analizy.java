package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = in.readLine()) != null) {
                String status = line.split(" ")[0];
                String time = line.split(" ")[1];
                if (status.contains("400") || status.contains("500")) {
                    rsl.add(time + ";");
                }
                if (status.contains("200") || status.contains("300")) {
                    rsl.add(time + System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String el : rsl) {
                out.write(el);
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