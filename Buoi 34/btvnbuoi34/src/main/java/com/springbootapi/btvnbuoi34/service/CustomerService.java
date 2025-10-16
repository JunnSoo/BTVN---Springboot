package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.dto.CustomerDto;
import com.springbootapi.btvnbuoi34.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
}
