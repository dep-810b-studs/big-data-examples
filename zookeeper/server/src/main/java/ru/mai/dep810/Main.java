package ru.mai.dep810;


import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * This program demonstrates a simple TCP/IP socket server.
 *
 * @author www.codejava.net
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, KeeperException {
        int port = 8888;
        byte[] portData = "8888".getBytes(StandardCharsets.UTF_8);
        byte[] hostData = "localhost".getBytes(StandardCharsets.UTF_8);

        ZKManager zkManager = new ZKManager();
        zkManager.create("/server-config", "/server-config".getBytes(StandardCharsets.UTF_8));
        zkManager.create("/server-config/port", portData);
        zkManager.create("/server-config/host", hostData);

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                writer.println("Hello,world!");
                writer.println(new Date().toString());
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}