package io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String status = line.split(" ")[0];
                int intStatus = Integer.parseInt(status);
                if (flag && (intStatus == 500 || intStatus == 400)) {
                    flag = false;
                    sb.append(line.split(" ")[1]).append(System.lineSeparator());
                }
                if (!flag && (intStatus != 500 && intStatus != 400)) {
                    flag = true;
                    sb.append(line.split(" ")[1]).append(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeTarget(target, sb.toString());
    }

    private void writeTarget(String file, String data) {
        try (BufferedWriter out = new BufferedWriter(new PrintWriter(file))) {
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}