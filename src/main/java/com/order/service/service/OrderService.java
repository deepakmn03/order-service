package com.order.service.service;
import com.order.service.repository.OrderRepository;
import com.order.service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.entity.Order;
import com.order.service.entity.User;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Order> getOrdersByUserId(Integer userId){
        return orderRepository.findByUserUserId(userId);
    }

    public Optional<Order> getOrderByOrderId(int orderId){
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order creatOrder(Order order){
        if(order.getUser() == null || order.getUser().getUserId() <= 0){
            throw new RuntimeException("Order must be associated with an existing User ID");
        }
        int userId = order.getUser().getUserId();
        Optional<User> existinguser = userRepository.findById(userId);
        User user = existinguser.get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    public Order updateOrder(int orderId, Order orderDetails){
       Optional<Order>order = orderRepository.findById(orderId);
       if(order.isPresent()){
        Order existingOrder = order.get();
        existingOrder.setOrderValue(orderDetails.getOrderValue());
        existingOrder.setUser(orderDetails.getUser());
        return orderRepository.save(existingOrder);
       }
       return null;
    }

    public void deleteOrder(int orderId){
        orderRepository.deleteById(orderId);
       }
    
}
