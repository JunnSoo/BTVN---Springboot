package com.springbootapi.btvn32.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam String author){
        return ResponseEntity.ok("Sach a - Tac gia: "+author);
    }
}

