package com.swiftfingers.rabbitmqdemo.controller;


import com.swiftfingers.rabbitmqdemo.dto.User;
import com.swiftfingers.rabbitmqdemo.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class MessageJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }


    @PostMapping (value = "/send")
    public ResponseEntity producer(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);

        return ResponseEntity.ok("User sent to RabbitMQ...");
    }
}
