package com.example.Cart.repository;

import com.example.Cart.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    public List<Order> findByUserId(Integer id);
}
