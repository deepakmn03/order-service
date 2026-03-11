package com.order.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.entity.Order;
import com.order.service.entity.User;
import com.order.service.repository.OrderRepository;
import com.order.service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String createUser(User user){
        userRepository.save(user);
        return "User with userId: "+ user.getUserId() + " and name: "  + user.getUsername() + "has been created";
    }

    public String deleteUserById(int userId){
        userRepository.deleteById(userId);
        return "User with user id: " + userId + " has been removed";
    }

    public List<Order> getOrdersByUserId(int id){
        return orderRepository.findAllById(null);
    }
}
