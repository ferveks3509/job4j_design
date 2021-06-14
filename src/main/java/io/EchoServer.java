package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\"".getBytes());
                   for (String text = in.readLine(); text != null && !text.isEmpty(); text = in.readLine()) {
                       System.out.println(text);
                       String str;
                       if (text.contains("?")) {
                           str = text.split("/")[1];
                           str = str.split(" ")[0];
                           str = str.substring(1);
                           if (str.equals("bye")) {
                               server.close();
                           }
                       }
                   }
                   out.write("hello\r\n".getBytes());
                }
            }
        }
    }
}