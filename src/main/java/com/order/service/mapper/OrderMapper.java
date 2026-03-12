package com.order.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.order.service.dto.OrderResponseDTO;
import com.order.service.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponseDTO toDTO(Order order);
    List<OrderResponseDTO> toDTOList(List<Order> order);
}
