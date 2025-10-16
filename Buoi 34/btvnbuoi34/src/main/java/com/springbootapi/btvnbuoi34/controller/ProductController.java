package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.Product;
import com.springbootapi.btvnbuoi34.request.ProductRequest;
import com.springbootapi.btvnbuoi34.respone.BaseRespone;
import com.springbootapi.btvnbuoi34.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest){
        try {
            Product product = productService.themSanPham(productRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Loi them san pham" + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getProducts(){
        try {
            return ResponseEntity.status(200).body(productService.hienThiToanBoSanPham());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Loi hien thi danh sach san pham" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        try {
            Product product = productService.timSanPhamTheoId(id);
            if(product != null){
                return ResponseEntity.status(200).body(product);
            }else {
                return ResponseEntity.status(200).body("Khong tim thay san pham");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Loi tim san pham theo id" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductRequest productRequest){
        try {
            Product product = productService.suaSanPham(id, productRequest);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Khong thay san pham" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        try {
            BaseRespone  baseRespone = new BaseRespone();
            boolean ok = productService.xoaSanPham(id);
            baseRespone.setCode(ok ? 200 : 400);
            baseRespone.setMessage(ok ? "Da xoa" : "Khong thay san pham");
            return ResponseEntity.status(HttpStatus.OK).body(baseRespone);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
