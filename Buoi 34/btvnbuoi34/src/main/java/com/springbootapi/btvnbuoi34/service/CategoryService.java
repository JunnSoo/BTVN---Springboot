package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.dto.productDto;
import com.springbootapi.btvnbuoi34.entity.Category;
import com.springbootapi.btvnbuoi34.entity.Product;
import com.springbootapi.btvnbuoi34.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    Category addCategory(CategoryRequest  categoryRequest);
    List<productDto> timToanBoSanPhamTheoCategory(int categoryId);

}
