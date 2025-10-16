package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.User;
import com.springbootapi.btvnbuoi34.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        userService.saveUsers(user);
        return ResponseEntity.ok("Them thanh cong");
    }
}
