package com.order.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private int orderId;
    private Long orderValue;
}
