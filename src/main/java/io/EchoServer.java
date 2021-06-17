package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String text = in.readLine(); text != null && !text.isEmpty(); text = in.readLine()) {
                        System.out.println(text);
                        if (text.contains("?")) {
                            text = text.split("/")[1];
                            text = text.split(" ")[0];
                            if (text.equals("?msg=Hello")) {
                                out.write("Hello, dear friend.\r\n".getBytes());
                            } else if (text.equals("?msg=Exit")) {
                                out.write("Server close\r\n".getBytes());
                                server.close();
                            } else {
                                out.write("What\r\n".getBytes());
                            }
                        }
                    }
                }
            }
        }
    }
}