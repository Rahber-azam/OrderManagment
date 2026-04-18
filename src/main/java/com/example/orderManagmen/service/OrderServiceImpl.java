package com.example.orderManagmen.service;

import com.example.orderManagmen.entity.Order;
import com.example.orderManagmen.entity.OrderStatus;
import com.example.orderManagmen.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // Implementation for creating an order
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setStatus(order.getStatus());

        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        orderRepository.delete(order);


    }
    @Override
    public List<Order> searchByProductName(String productName) {

        // Validate input (best practice)
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }

        // Call repository
        return orderRepository.findByProductNameContainingIgnoreCase(productName);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}