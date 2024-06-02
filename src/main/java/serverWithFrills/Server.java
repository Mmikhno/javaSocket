package serverWithFrills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String response = "";
        String name = "";
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    System.out.printf("Client (port %s) is accepted\n", clientSocket.getPort());
                    out.println("What is your name?");
                    name = in.readLine();
                    out.println(String.format("Hello %s! Are you child? (yes/no)", name));
                    response = in.readLine().toLowerCase();
                    switch (response) {
                        case "yes":
                            out.printf("Welcome to the kids area, %s! Let's play!", name);
                            break;
                        case "no":
                            out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!\n", name);
                            break;
                        default:
                            clientSocket.close();
                    }
                    System.out.println("Client (port) " + clientSocket.getPort() + " is disconnected");
                }
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}

