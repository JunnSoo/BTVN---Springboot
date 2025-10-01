package com.springbootapi.btvn32.service;

import com.springbootapi.btvn32.entity.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final List<Order> listOrder = new ArrayList<>();
    public void   addOrder(Order order){
        listOrder.add(order);
    }
    public List<Order> getListOrder(){
        return listOrder;
    }
}
