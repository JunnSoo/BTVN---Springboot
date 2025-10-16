package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.Employee;
import com.springbootapi.btvnbuoi34.repository.EmployeeRepository;
import com.springbootapi.btvnbuoi34.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getEmployee(int page, int size, List<String> sortParam) {
        System.out.println("sort param:"+sortParam);
        Sort sort = Sort.unsorted();
        if (sortParam != null && !sortParam.isEmpty()) {
            List<Sort.Order> orders = new ArrayList<>();

            // 🧩 Nếu chỉ có 1 điều kiện (Spring parse thành [salary, desc])
            if (sortParam.size() <= 2 && !sortParam.get(0).contains(",")) {
                String field = sortParam.get(0).trim();
                String dir = (sortParam.size() > 1) ? sortParam.get(1).trim() : "asc";

                orders.add("desc".equalsIgnoreCase(dir)
                        ? Sort.Order.desc(field)
                        : Sort.Order.asc(field));
            }
            // 🧩 Nếu có nhiều điều kiện (Spring parse thành ["salary,desc", "name,asc"])
            else {
                for (String s : sortParam) {
                    String[] parts = s.split(",");
                    String field = parts[0].trim();
                    String dir = parts.length > 1 ? parts[1].trim() : "asc";

                    if (!field.equalsIgnoreCase("asc") && !field.equalsIgnoreCase("desc")) {
                        orders.add("desc".equalsIgnoreCase(dir)
                                ? Sort.Order.desc(field)
                                : Sort.Order.asc(field));
                    }
                }
            }
            sort = Sort.by(orders);// gộp tất cả tiêu chí sắp xếp lại thành một đối tượng Sort
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }
}
