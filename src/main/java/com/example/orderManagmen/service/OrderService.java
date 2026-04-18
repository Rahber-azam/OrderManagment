package com.example.orderManagmen.service;

import com.example.orderManagmen.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
     List<Order> getAllOrders();
    List<Order> searchByProductName(String productName);
    List<Order> getOrdersByPriceRange(double min, double max);
}
