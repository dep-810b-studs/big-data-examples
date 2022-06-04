package ru.mai.dep810;

import java.net.*;
import java.io.*;

/**
 * This program demonstrates a simple TCP/IP socket client.
 *
 * @author www.codejava.net
 */
public class Main {

    public static void main(String[] args) {

        ZKManager zkManager = new ZKManager();
        String hostData = zkManager.getZNodeData("/server-config/host",true);
        String portData = zkManager.getZNodeData("/server-config/port",true);

        try (Socket socket = new Socket(hostData, Integer.parseInt(portData))) {

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String message = reader.readLine();

            System.out.println(message);


        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}