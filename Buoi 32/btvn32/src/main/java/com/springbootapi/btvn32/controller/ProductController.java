package com.springbootapi.btvn32.controller;

import com.springbootapi.btvn32.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public ResponseEntity<List<String>> getProducts(){
        List<String> list = List.of("Sach","Tu lanh","TV");
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable int id){
        return ResponseEntity.ok("detail product " +id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestParam String name){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return ResponseEntity.ok("delete product " +id);
    }
}
