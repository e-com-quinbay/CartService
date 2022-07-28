package com.example.Cart.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CartReturn{
    List<CartReturnArray> cart;
}

