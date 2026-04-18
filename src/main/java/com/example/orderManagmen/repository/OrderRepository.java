package com.example.orderManagmen.repository;

import com.example.orderManagmen.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
