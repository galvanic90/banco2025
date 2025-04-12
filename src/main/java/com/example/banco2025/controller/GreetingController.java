package com.example.banco2025.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/")
    ResponseEntity<String> wellcome() {
        return new ResponseEntity<>("<header><title>udea-bank</title></header>\n"+"<h1>" + "WELLCOME TO UDEA BANK!" + "</h1>", HttpStatus.OK);
    }

}
