package com.example.Cart.service;


import com.example.Cart.entity.Order;
import com.example.Cart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UtilService utilService;

    public Boolean order(Order order)
    {
//        if(utilService.checkForStock(order.getProductId(),order.getQuantity())) {
            order.setId(idGenerate() + 1);
            order.setTotal(order.getPrice()*order.getQuantity());
//            if(utilService.decreaseStock(order.getProductId(),order.getQuantity()))
             orderRepository.save(order);
//            return false;
//        }
        return false;
    }
    public Integer idGenerate()
    {
        return orderRepository.findAll().size();
    }

    public List<Order> myOrder(Integer id)
    {
        return orderRepository.findByUserId(id);
    }
}

