package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.Category;
import com.springbootapi.btvnbuoi34.repository.CategoryRepository;
import com.springbootapi.btvnbuoi34.request.CategoryRequest;
import com.springbootapi.btvnbuoi34.request.ProductRequest;
import com.springbootapi.btvnbuoi34.service.CategoryService;
import com.springbootapi.btvnbuoi34.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService  categoryService;

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest categoryRequest){
        try{
            Category category = categoryService.addCategory(categoryRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryRequest);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest, @PathVariable int id) {
        try {
            productService.themSanPhamTheoCategory(productRequest, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(productRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getProduct(@PathVariable int id){
        try{
            return ResponseEntity.ok(categoryService.timToanBoSanPhamTheoCategory(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
