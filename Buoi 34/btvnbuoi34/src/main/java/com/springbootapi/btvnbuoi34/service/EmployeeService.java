package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService{
    Page<Employee> getEmployee(int page, int size, List<String> sortParam);
}
