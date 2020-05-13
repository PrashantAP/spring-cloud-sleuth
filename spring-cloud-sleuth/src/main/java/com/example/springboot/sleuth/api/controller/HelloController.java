package com.example.springboot.sleuth.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello-api")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHello")
    public String sayHello() {
        LOGGER.info("Before calling hello service...");
        String forObject = restTemplate.getForObject("http://localhost:8080/hello-api/hello", String.class);
        LOGGER.info("After calling hello service...");
        return forObject;
    }

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("called hello service...");
        return "Hello World!!!...";
    }
}
