package com.order.service.service;
import com.order.service.repository.OrderRepository;
import com.order.service.repository.UserRepository;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.dto.OrderRequestDTO;
import com.order.service.dto.OrderResponseDTO;
import com.order.service.entity.Order;
import com.order.service.entity.User;
import com.order.service.mapper.OrderMapper;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderMapper orderMapper;


    public List<OrderResponseDTO> getOrdersByUserId(Integer userId){
        List<Order> orders = orderRepository.findByUserUserId(userId);
        return orderMapper.toDTOList(orders);
    }

    public OrderResponseDTO getOrderByOrderId(int orderId){
        Order order = orderRepository.findById(orderId)
                      .orElseThrow(() -> new RuntimeException());
        return orderMapper.toDTO(order);
    }

    public List<OrderResponseDTO> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDTOList(orders);
    }

    public OrderResponseDTO creatOrder(Long orderValue, int userId){
        Optional<User> existingUser = userRepository.findById(userId);
        if(!existingUser.isPresent()){
            throw new RuntimeException("User with ID: " + userId + " not found");
        }
        Order order = new Order();
        order.setOrderValue(orderValue);
        User user = existingUser.get();
        order.setUser(user);
        user.addOrder(order);
        Order finalOrder = orderRepository.save(order);
        return orderMapper.toDTO(finalOrder);
    }

    public OrderResponseDTO updateOrder(int orderId, OrderRequestDTO orderDetails){
       Order order = orderRepository.findById(orderId)
                     .orElseThrow(() -> new RuntimeException("Order with ID: " + orderId + " not found"));
        
        // Update order value
        order.setOrderValue(orderDetails.getOrderValue());
        
        // Update user if userId is provided
        if(orderDetails.getUserId() > 0){
            User user = userRepository.findById(orderDetails.getUserId())
                        .orElseThrow(() -> new RuntimeException("User with ID: " + orderDetails.getUserId() + " not found"));
            order.setUser(user);
        }
        
        Order updatedOrder = orderRepository.save(order);
       return orderMapper.toDTO(updatedOrder);
    }

    public String deleteOrder(int orderId){
        orderRepository.deleteById(orderId);
        return "Order with order ID: " + orderId + " has been deleted.";
       }
    
}
