package project;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class DistributedDocDBServer {
    private static final int PORT = 12345;
    private static final int NUM_WORKERS = 4;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < NUM_WORKERS; i++) {
            new WorkerThread(taskQueue).start();
        }
        System.out.println("Server started on port " + PORT);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            String command = in.readLine();
            if (command != null && !command.trim().isEmpty()) {
                taskQueue.offer(new Task(command, clientSocket));
            }
        }
    }
}
