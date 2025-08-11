## DistributedDocDB - Simple Distributed Document Storage System

DistributedDocDB is a Java-based client-server application designed to store, retrieve, and delete files remotely over a network. This project demonstrates key concepts of concurrent programming and TCP socket communication by allowing multiple clients to interact with the server simultaneously.

## Idea/Workflow
DistributedDocDB is a simple client-server Java application that enables storing, retrieving, and deleting files remotely over a network. The server handles client requests concurrently, maintaining files under a dedicated directory. Clients send commands like PUT, GET, DELETE to manipulate files on the server.
The workflow consists of clients connecting to the server, sending textual commands, and the server processing these commands by reading/writing files in its data directory, then responding back. The server uses worker threads to handle multiple clients concurrently, ensuring responsiveness.

## Features
- **PUT <filename> <content>**: Upload and save a file with specified content to the server.
- **GET <filename>**: Retrieve the content of a file from the server.
- **DELETE <filename>**: Remove a file from the server’s storage.
- **EXIT**: Close the client connection gracefully.

## Architecture
- **Server (`DistributedDocDBServer.java`)**:  
  Listens on a TCP port, accepts client connections, processes commands, and manages file storage under the `data/` directory.
  
- **Client (`Client.java`)**:  
  Provides a command-line interface to send commands to the server and display server responses.
  
- **Supporting classes (`Task.java`, `WorkerThread.java`)**:  
  Handle client requests and server concurrency.

## Setup and Running

### Prerequisites
- Java Development Kit (JDK) 8 or later installed
- Basic terminal/command line knowledge

### Steps

1. **Clone the repository:**
    ```bash
    git clone https://github.com/mihaelacoman1/DataStructureEngine
    cd DataStructureEngine
    ```

2. **Compile the Java files:**
    ```bash
    javac project/*.java
    ```

3. **Create the data directory to store files:**
    ```bash
    mkdir data
    ```

4. **Start the server (keep this terminal open):**
    ```bash
    java project.DistributedDocDBServer
    ```

5. **Open a new terminal and start the client:**
    ```bash
    java project.Client
    ```

6. **Use the client commands as prompted:**
    - `PUT <filename> <content>`
    - `GET <filename>`
    - `DELETE <filename>`
    - `EXIT`

## Example Usage

```bash
PUT test.txt HelloWorld
GET test.txt
DELETE test.txt
EXIT


