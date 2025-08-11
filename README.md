# DistributedDocDB

## Overview
DistributedDocDB is a simple client-server application implemented in Java that allows clients to perform basic file operations — store, retrieve, and delete files — on a remote server. The server maintains a directory of files, and clients communicate commands to manage these files over a network connection.

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


