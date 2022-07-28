package com.example.Cart.entity;

import com.example.Cart.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartReturnArray {
    private ProductDto productDto;
    private Integer quantity;
}
