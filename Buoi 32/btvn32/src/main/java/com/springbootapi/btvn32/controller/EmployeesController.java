package com.springbootapi.btvn32.controller;

import com.springbootapi.btvn32.entity.Employee;
import com.springbootapi.btvn32.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            return ResponseEntity.status(404).body("Employee not found");
        }
        return ResponseEntity.ok(employee);
    }
}
