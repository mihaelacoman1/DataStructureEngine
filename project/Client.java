package project;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DistributedDocDB Client");
        System.out.println("Comenzi disponibile:");
        System.out.println(" - PUT <filename> <content>");
        System.out.println(" - GET <filename>");
        System.out.println(" - DELETE <filename>");
        System.out.println(" - EXIT");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("EXIT")) {
                System.out.println("Client oprit.");
                break;
            }
            if (command.equalsIgnoreCase("EXIT")) {
                System.out.println("Client oprit.");
                break;
            }
            try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()))) {
                out.println(command);
                String response = in.readLine();
                if (response != null) {
                    System.out.println("SERVER: " + response);
                }
            } catch (IOException e) {
                System.out.println("Eroare la conectare: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

