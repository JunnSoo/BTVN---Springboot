package com.springbootapi.btvn32.controller;

import com.springbootapi.btvn32.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok("result = "+calculatorService.cong(a,b));
    }

    @GetMapping("/subtract")
    public ResponseEntity<String> subtract(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok("result = "+calculatorService.tru(a,b));
    }

    @GetMapping("/multiply")
    public ResponseEntity<String> multiply(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok("result = "+calculatorService.nhan(a,b));
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok("result = "+calculatorService.chia(a,b));
    }
}
