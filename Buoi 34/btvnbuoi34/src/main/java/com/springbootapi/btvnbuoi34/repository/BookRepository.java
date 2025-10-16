package com.springbootapi.btvnbuoi34.repository;

import com.springbootapi.btvnbuoi34.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByAuthor(String author);

    @Query(value = "SELECT b FROM Book b WHERE b.price >= :minPrice AND b.price <= :maxPrice")
    List<Book> findByPrice(@Param("minPrice") double minPrice,@Param("maxPrice") double maxPrice);
}
