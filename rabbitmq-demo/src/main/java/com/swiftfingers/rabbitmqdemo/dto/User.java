package com.swiftfingers.rabbitmqdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
