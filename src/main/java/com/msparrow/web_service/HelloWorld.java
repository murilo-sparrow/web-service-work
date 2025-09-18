package com.msparrow.web_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping
    public String hello() {
        return "boa!";
    }
}
