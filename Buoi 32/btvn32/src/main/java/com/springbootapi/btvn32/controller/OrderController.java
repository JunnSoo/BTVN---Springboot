package com.springbootapi.btvn32.controller;

import com.springbootapi.btvn32.entity.Order;
import com.springbootapi.btvn32.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> listOrder = orderService.getListOrder();
        return ResponseEntity.ok(listOrder);
    }
}
