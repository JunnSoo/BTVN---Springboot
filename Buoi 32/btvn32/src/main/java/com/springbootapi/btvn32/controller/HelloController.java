package com.springbootapi.btvn32.controller;

import com.springbootapi.btvn32.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    @Autowired
    private GreetingService greetingService;


    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello Springboot!");
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam String name){
        return ResponseEntity.ok(greetingService.sayHello(name));
    }
}
