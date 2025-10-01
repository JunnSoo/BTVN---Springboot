package com.springbootapi.btvn32.service;

import com.springbootapi.btvn32.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private static final Map<Integer,Employee> employees = new HashMap<>();
    static {
        employees.put(1,new Employee(1,"An"));
        employees.put(2,new Employee(2,"Binh"));
    }
    public Employee getEmployee(int id){
        return employees.get(id);
    }
}
