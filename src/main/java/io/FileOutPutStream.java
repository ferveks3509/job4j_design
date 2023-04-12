package io;

import java.io.FileOutputStream;

public class FileOutPutStream {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    String result = String.valueOf(i * j);
                    out.write(result.getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
