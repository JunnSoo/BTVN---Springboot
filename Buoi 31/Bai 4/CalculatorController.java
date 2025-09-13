package com.cybersoft.demospringboot10.controller;

import com.cybersoft.demospringboot10.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int a,@RequestParam int b) {
        return calculatorService.add(a,b);
    }

    @GetMapping("/sub")
    public int sub(@RequestParam int a,@RequestParam int b) {
        return calculatorService.sub(a,b);
    }

    @GetMapping("/mul")
    public int mul(@RequestParam int a,@RequestParam int b) {
        return calculatorService.mul(a,b);
    }

    @GetMapping("/div")
    public int div(@RequestParam int a,@RequestParam int b) {
        return calculatorService.div(a,b);
    }
}
