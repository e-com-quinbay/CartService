package com.example.Cart.dto;

import com.example.Cart.entity.CartArray;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CartReturnDto {
    private Integer userId;
    private List<CartArray> card;
    private Double amount;
}
