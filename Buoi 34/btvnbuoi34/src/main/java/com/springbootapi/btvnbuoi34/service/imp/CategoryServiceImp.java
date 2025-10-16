package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.dto.productDto;
import com.springbootapi.btvnbuoi34.entity.Category;
import com.springbootapi.btvnbuoi34.entity.Product;
import com.springbootapi.btvnbuoi34.repository.CategoryRepository;
import com.springbootapi.btvnbuoi34.repository.ProductRepository;
import com.springbootapi.btvnbuoi34.request.CategoryRequest;
import com.springbootapi.btvnbuoi34.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public Category addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<productDto> timToanBoSanPhamTheoCategory(int categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new RuntimeException("Category không tồn tại");
        }
        List<productDto> products = productRepository.findByCategoryId(categoryId).stream()
                .map(p-> new productDto(p.getId(),p.getName(),p.getPrice(),p.getDescription()))
                .toList();
        if (products.isEmpty()) {
            throw new RuntimeException("Không có sản phẩm nào trong category này");
        }
        return products;

    }
}
