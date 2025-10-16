package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<?> getOrdersByDate(@RequestParam LocalDate from, @RequestParam LocalDate to) {
        return  ResponseEntity.ok(ordersService.getOrdersByDate(from,to));
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTop() {
        return ResponseEntity.ok(ordersService.getOrdersByTotalAmount());
    }
}
