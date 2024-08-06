package com.learn.server.tcpserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TcpServer {

    private static final int PORT = 54321;

    @PostConstruct
    public void startServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server started on port " + PORT);
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    handleClient(clientSocket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 OutputStream out = clientSocket.getOutputStream()) {
                String message = in.readLine();
                System.out.println("Received message: " + message);
                String response = "Echo: " + message + "\n";
                out.write(response.getBytes());
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SpringApplication.run(TcpServer.class, args);
    }
}
