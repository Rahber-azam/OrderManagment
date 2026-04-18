package com.example.orderManagmen.repository;

import com.example.orderManagmen.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProductNameContainingIgnoreCase(String productName);
}

