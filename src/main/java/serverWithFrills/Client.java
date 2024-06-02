package serverWithFrills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String entry = "";
        String input = "";
        try (Socket clientSocket = new Socket("netology.homework", 8080);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                entry = reader.readLine();
                if (entry == null || entry == "") {
                    System.out.println("Client is disconnected...");
                    break;
                }
                System.out.println(entry);
                input = consoleReader.readLine();
                writer.println(input);
                continue;
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
