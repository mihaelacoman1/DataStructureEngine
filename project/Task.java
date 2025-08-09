package project;

import java.net.Socket;

public class Task {
    private String command;
    private Socket clientSocket;

    public Task(String command, Socket clientSocket) {
        this.command = command;
        this.clientSocket = clientSocket;
    }

    public String getCommand() {
        return command;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
