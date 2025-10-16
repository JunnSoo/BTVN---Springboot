package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.dto.CustomerDto;
import com.springbootapi.btvnbuoi34.entity.Customer;
import com.springbootapi.btvnbuoi34.repository.CustomerRepository;
import com.springbootapi.btvnbuoi34.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(c -> new CustomerDto(c.getId(),c.getName(),c.getPhone()))
                .collect(Collectors.toList());
    }
}
