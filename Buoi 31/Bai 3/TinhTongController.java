package com.cybersoft.demospringboot10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinhTongController {
    @GetMapping("/sum1")
    public String sum1(@RequestParam int a, @RequestParam int b) {
        int sum = a + b;
        return String.valueOf(sum);
    }

    @GetMapping("/sum2")
    public int sum2(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}
