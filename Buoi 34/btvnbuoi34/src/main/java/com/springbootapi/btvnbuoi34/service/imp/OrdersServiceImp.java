package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.Orders;
import com.springbootapi.btvnbuoi34.repository.OrdersRepository;
import com.springbootapi.btvnbuoi34.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdersServiceImp implements OrdersService{
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Orders> getOrdersByDate(LocalDate from, LocalDate to) {
        return ordersRepository.getOrdersByDate(from,to);
    }

    @Override
    public List<Orders> getOrdersByTotalAmount() {
        return ordersRepository.getOrdersByTotalAmount();
    }
}
