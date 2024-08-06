// package com.learn.client.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import com.learn.client.tcpclient.TcpClient;

// @RestController
// public class TcpClientController {

//     @Autowired
//     private TcpClient tcpClient;

//     @GetMapping("/send")
//     public String sendMessage(@RequestParam String message) {
//         return tcpClient.sendMessage(message);
//     }
// }

