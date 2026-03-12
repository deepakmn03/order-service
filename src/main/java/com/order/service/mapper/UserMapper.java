package com.order.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.order.service.dto.UserResponseDTO;
import com.order.service.entity.User;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface UserMapper {

    @Mapping(source = "userId", target = "id")
    @Mapping(target = "orderCount", expression = "java(user.getOrders()!= null ? user.getOrders().size() : 0)")
    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTOList(List<User>user);
}
