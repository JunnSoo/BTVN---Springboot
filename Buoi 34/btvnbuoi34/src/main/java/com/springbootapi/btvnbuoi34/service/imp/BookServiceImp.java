package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.Book;
import com.springbootapi.btvnbuoi34.repository.BookRepository;
import com.springbootapi.btvnbuoi34.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> timTheoTacGia(String author){

        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> locTheoGia(double minPrice, double maxPrice) {
        return  bookRepository.findByPrice(minPrice,maxPrice);
    }
}
