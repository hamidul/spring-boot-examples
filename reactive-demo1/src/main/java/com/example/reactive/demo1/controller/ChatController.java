package com.example.reactive.demo1.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.reactive.demo1.model.Message;
import com.example.reactive.demo1.model.OutputMessage;


//ChatController.java
@Controller
public class ChatController {

 @GetMapping("/")
 public String index() {
     return "index";
 }


 
 @MessageMapping("/chat")
 @SendTo("/topic/messages")
 public OutputMessage send(Message message) throws Exception {
     String time = new SimpleDateFormat("HH:mm").format(new Date());
     return new OutputMessage(message.getFrom(), message.getText(), time);
 }
}
