package com.learn.client.tcpclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

@Component
public class TcpClient implements CommandLineRunner {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 54321;
    private static final int RETRY_INTERVAL = 3; // Retry every 5 seconds

    @Override
    public void run(String... args) throws Exception {
        boolean connected = false;
        while (!connected) {
            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                 OutputStream out = socket.getOutputStream();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Connected to server on port " + SERVER_PORT);
                String message = "Hello from client";
                out.write((message + "\n").getBytes());
                String response = in.readLine();
                System.out.println("Server response: " + response);
                connected = true;
            } catch (Exception e) {
                System.out.println("Failed to connect to server. Retrying in " + RETRY_INTERVAL + " seconds...");
                TimeUnit.SECONDS.sleep(RETRY_INTERVAL);
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(TcpClient.class, args);
    }
}




