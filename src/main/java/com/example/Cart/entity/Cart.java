package com.example.Cart.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection="cart")
public class Cart {
//    @Id
    private Integer userId;
    private CartArray[] card;
}
