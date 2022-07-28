package com.example.Cart.repository;

import com.example.Cart.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart,String> {

    Cart findByUserId(Integer id);
}