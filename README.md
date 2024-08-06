# TCP-Socket-Springboot

This project is an example of server and client side of TCP Socket communication using Java Spring Boot. The server listens for incoming connections and echoes received messages back to the client. The client attempts to connect to the server and sends a message upon successful connection.

## Project Structure

The project is divided into two separate Spring Boot applications:
- `server`: The TCP server-side application.
- `client`: The TCP client-side application.

## Getting Started

### Prerequisites

- JDK 17 or higher
- Gradle
- An IDE such as IntelliJ IDEA or Eclipse

### Setting Up the Projects

#### 1. Clone the Repository

```sh
git clone https://github.com/muhamadnaufalA/TCP-Socket-Springboot.git
```

#### 2. Running Server

```sh
cd server
./gradlew clean build
./gradlew bootRun
```

#### 3. Running Client

```sh
cd client
./gradlew clean build
./gradlew bootRun
```