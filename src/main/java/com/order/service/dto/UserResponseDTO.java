package com.order.service.dto;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private int id;
    private String username;
    private String email;
    private String address;
    private int orderCount;
    private List<OrderResponseDTO> orders;
}
