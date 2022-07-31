package com.example.Cart.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderList {
    private String productId;
    private String productName;
    private double price;
    private Integer quantity;
}
