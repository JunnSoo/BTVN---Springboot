package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.Product;
import com.springbootapi.btvnbuoi34.request.CategoryRequest;
import com.springbootapi.btvnbuoi34.request.ProductRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    Product themSanPham(ProductRequest productRequest);
    Product themSanPhamTheoCategory(ProductRequest productRequest, int id);
    List<Product> hienThiToanBoSanPham();

    Product timSanPhamTheoId(int id);
    Product suaSanPham(int id, ProductRequest productRequest);
    boolean xoaSanPham(int id);
}
