package com.springbootapi.btvnbuoi34.repository;

import com.springbootapi.btvnbuoi34.entity.Category;
import com.springbootapi.btvnbuoi34.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategoryId(int categoryId);
}
