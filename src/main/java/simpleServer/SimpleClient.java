package simpleServer;

import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8080);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Write your name: ");
            String name = bufferedReader.readLine();
            writer.println(name);
            System.out.println("simpleServer.Server's answer: " + reader.readLine());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
