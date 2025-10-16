package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.Employee;
import com.springbootapi.btvnbuoi34.repository.EmployeeRepository;
import com.springbootapi.btvnbuoi34.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @GetMapping
    public ResponseEntity<?> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(name = "sort",required = false) List<String> sort
            ){

        Page<Employee> result = employeeService.getEmployee(page, size, sort);
        return ResponseEntity.ok().body(result);
    }
}
