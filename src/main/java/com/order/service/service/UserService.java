package com.order.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.dto.OrderResponseDTO;
import com.order.service.dto.UserResponseDTO;
import com.order.service.entity.Order;
import com.order.service.entity.User;
import com.order.service.mapper.OrderMapper;
import com.order.service.mapper.UserMapper;
import com.order.service.repository.OrderRepository;
import com.order.service.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

import com.order.service.exception.UserNotFoundException;

@Log4j2
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;
    
    @Transactional
    public UserResponseDTO getUserById(int id){
        User user = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toDTO(user);            
    }

    @Transactional
    public List<UserResponseDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userMapper.toDTOList(userList);
    }

    public String createUser(User user){
        userRepository.save(user);
        log.info("A new user has been created with id: {}", user.getUserId());
        return "User with userId: "+ user.getUserId() + " and name: "  + user.getUsername() + "has been created";
    }

    public String deleteUserById(int userId){
        userRepository.deleteById(userId);
        log.warn("A user with ID: {} has been deleted", userId);
        return "User with user id: " + userId + " has been removed";
    }

    public List<OrderResponseDTO> getOrdersByUserId(int id){
        List<Order> orders = orderRepository.findAllById(null);
        return orderMapper.toDTOList(orders);
    }
}
