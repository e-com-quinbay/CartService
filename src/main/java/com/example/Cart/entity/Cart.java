package com.example.Cart.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Getter
@Setter
@ToString
@Document(collection="cart")
public class Cart {
    @Id
    private Integer userId;
    private List<CartArray> card;
}
