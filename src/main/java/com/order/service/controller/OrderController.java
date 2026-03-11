package com.order.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.entity.Order;
import com.order.service.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/status")
    public ResponseEntity<String> orderServiceStatus(){
        System.out.println("Order service is live now!!" + "\n" + "Current thread is: " + Thread.currentThread().getName());
        return ResponseEntity.ok("Order service is live now!!!");
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable int orderId){
        Optional<Order> order = orderService.getOrderByOrderId(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/get/user/{userId}")
    public ResponseEntity<List<Order>> getAllOrdersByUserId(@PathVariable int userId){
        List<Order>orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order>orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        orderService.creatOrder(order);
        return ResponseEntity.ok("A new order has been created");
    }

    @DeleteMapping("/remove/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order has been deleted with orderId:  " + orderId);
    }

    @PatchMapping("/update/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable int orderId, @RequestBody Order order){
        Order newOrder = orderService.updateOrder(orderId, order);
        return ResponseEntity.ok(newOrder);
    }
}
