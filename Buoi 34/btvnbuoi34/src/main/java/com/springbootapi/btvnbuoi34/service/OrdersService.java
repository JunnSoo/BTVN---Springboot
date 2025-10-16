package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.Orders;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface OrdersService {
    List<Orders> getOrdersByDate(LocalDate from,LocalDate to);
    List<Orders> getOrdersByTotalAmount();
}
