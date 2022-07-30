package com.example.Cart.entity;

import com.example.Cart.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartArray {
    private ProductDto product;
    private Integer quantity;
}
