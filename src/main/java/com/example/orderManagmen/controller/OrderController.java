package com.example.orderManagmen.controller;
import com.example.orderManagmen.entity.Order;
import com.example.orderManagmen.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/orders")
    public class OrderController {

        private final OrderService orderService;

        // Constructor Injection (best practice ✅)
        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }

        // ✅ CREATE ORDER
        @PostMapping
        public Order createOrder(@RequestBody Order order) {
            return orderService.createOrder(order);
        }

        // ✅ GET ORDER BY ID
        @GetMapping("/{id}")
        public Order getOrderById(@PathVariable Long id) {
            return orderService.getOrderById(id);
        }

        // ✅ GET ALL ORDERS
        @GetMapping
        public List<Order> getAllOrders() {
            return orderService.getAllOrders();
        }

        // ✅ UPDATE ORDER
        @PutMapping("/{id}")
        public Order updateOrder(@PathVariable Long id,
                                 @RequestBody Order order) {
            return orderService.updateOrder(id, order);
        }

        // ✅ DELETE ORDER (MAIN REQUIREMENT 🔥)
        @DeleteMapping("/{id}")
        public String deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
            return "Order deleted successfully";
        }
        @GetMapping("/search")
        public List<Order> searchOrders(@RequestParam String productName) {
            return orderService.searchByProductName(productName);
        }
    }

