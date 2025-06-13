package com.codewithmosh.store.controllers;

import com.codewithmosh.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Representational State Transfer (a set of rules that define how applications should communicate over HTTP)
public class MessageController {
    @RequestMapping("/hello")
    public Message sayHello(){
        return new Message("Hello World!");
    }
}
