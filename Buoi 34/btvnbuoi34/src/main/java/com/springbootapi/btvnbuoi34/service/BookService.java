package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> timTheoTacGia(String author);
    List<Book> locTheoGia(double minPrice, double maxPrice);
}
