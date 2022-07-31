package com.example.Cart.controler;


import com.example.Cart.entity.Cart;
import com.example.Cart.entity.CartArray;
import com.example.Cart.entity.ListOrder;
import com.example.Cart.entity.Order;
import com.example.Cart.service.CartService;
import com.example.Cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/order")
@CrossOrigin(value = "*")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;

    @PostMapping()
    public Order order(@RequestBody Order order)
    {
       return orderService.order(order);
    }



    @GetMapping(value="/cart/{id}")
    public  Order orderCart(@PathVariable(value="id") Integer id)
    {
        Cart cart=cartService.getCart(id);
        return orderService.orderCart(cart);
    }


    @GetMapping(value = "/myorder/{id}")
    public List<Order> myOrder(@PathVariable(value = "id") Integer id) {
        return orderService.myOrder(id);
    }
}
