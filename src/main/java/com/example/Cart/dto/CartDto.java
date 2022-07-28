package com.example.Cart.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Document
public class CartDto {
    @Id
    String userId;
    List<CartContent.CartContent> cart = new ArrayList<>();
}

