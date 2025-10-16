package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.Book;
import com.springbootapi.btvnbuoi34.repository.BookRepository;
import com.springbootapi.btvnbuoi34.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/search",params = "author")
    public ResponseEntity<?> timSachTheoTacGia(@RequestParam String author){
        List<Book> books = bookService.timTheoTacGia(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "/search",params = {"minPrice","maxPrice"})
    public ResponseEntity<?> timSachTheoGia(@RequestParam double minPrice,@RequestParam double maxPrice){
        List<Book> listBook  = bookService.locTheoGia(minPrice,maxPrice);
        if(listBook.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        return ResponseEntity.ok(listBook);
    }
}
