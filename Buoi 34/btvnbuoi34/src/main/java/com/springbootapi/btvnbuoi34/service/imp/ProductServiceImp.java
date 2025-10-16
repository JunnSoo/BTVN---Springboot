package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.Category;
import com.springbootapi.btvnbuoi34.entity.Product;
import com.springbootapi.btvnbuoi34.repository.CategoryRepository;
import com.springbootapi.btvnbuoi34.repository.ProductRepository;
import com.springbootapi.btvnbuoi34.request.CategoryRequest;
import com.springbootapi.btvnbuoi34.request.ProductRequest;
import com.springbootapi.btvnbuoi34.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product themSanPham(@RequestBody ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        return productRepository.save(product);
    }

    @Override
    public List<Product> hienThiToanBoSanPham() {
        return productRepository.findAll();
    }

    @Override
    public Product timSanPhamTheoId(int id){
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if(optional.isPresent()){
            product = optional.get();
        }
        return product;
    }

    @Override
    public Product suaSanPham(int id, ProductRequest productRequest){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        return productRepository.save(product);
    }

    @Override
    public boolean xoaSanPham(int id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product themSanPhamTheoCategory(ProductRequest productRequest, int id){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());

        Category category = new Category();
        category.setId(id);
        product.setCategory(category);
        return productRepository.save(product);
    }

}
