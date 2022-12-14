package com.example.Cart.dto;

import com.example.Cart.entity.OrderList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderDto {
    private Integer id;
    private Integer userId;
    private List<OrderList> products;
    private double total;
}
