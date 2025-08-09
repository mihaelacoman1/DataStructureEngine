package project;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {
    private BlockingQueue<Task> taskQueue;

    public WorkerThread(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    private String processCommand(String command) {
        String[] parts = command.split(" ", 3);
        if (parts.length < 2) return "ERROR: Invalid command";

        String action = parts[0].toUpperCase();
        String filename = parts[1];
        File file = new File("data/" + filename);

        try {
            switch (action) {
                case "PUT":
                    if (parts.length < 3) return "ERROR: PUT needs <filename> <content>";
                    String content = parts[2];
                    try (FileWriter fw = new FileWriter(file)) {
                        fw.write(content);
                    }
                    return "OK: File saved";

                case "GET":
                    if (!file.exists()) return "ERROR: File not found";
                    return new String(Files.readAllBytes(file.toPath()));

                case "DELETE":
                    if (!file.exists()) return "ERROR: File not found";
                    file.delete();
                    return "OK: File deleted";

                default:
                    return "ERROR: Unknown command";
            }
        } catch (IOException e) {
            return "ERROR: " + e.getMessage();
        }
    }
    public void run() {
        while (true) {
            try {
                Task task = taskQueue.take(); 
                String command = task.getCommand();
                Socket clientSocket = task.getClientSocket();

                String response = processCommand(command);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(response);

                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


