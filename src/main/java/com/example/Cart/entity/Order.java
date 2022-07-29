package com.example.Cart.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Getter
@Setter
@ToString
@Document(collection = "order")
public class Order {

    @Id
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Float price;
    private Integer quantity;
    private Float total;

}