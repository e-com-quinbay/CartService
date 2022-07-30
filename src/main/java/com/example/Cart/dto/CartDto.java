package com.example.Cart.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class CartDto {
    @Id
    private Integer userId;
    private String productId;
    private Integer quantity;
}

