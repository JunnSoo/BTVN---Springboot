package com.springbootapi.btvnbuoi34.repository;

import com.springbootapi.btvnbuoi34.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT o FROM Orders o WHERE o.created_at BETWEEN :from AND :to")
    public List<Orders> getOrdersByDate(@Param("from") LocalDate from,@Param("to") LocalDate to);

    @Query(value = "SELECT o FROM Orders o order by o.total_amount desc LIMIT 5")
    public List<Orders> getOrdersByTotalAmount();
}
