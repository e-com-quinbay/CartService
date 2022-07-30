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
    public void order(@RequestBody Order order)
    {
       orderService.order(order);
    }
    @PostMapping(value = "/cart")
    public  void orderCart(@RequestBody Order order)
    {
        orderService.order(order);
        cartService.reduceCart(order.getUserId(),order.getProductId(),order.getQuantity());
    }
    @GetMapping(value = "/myorder/{id}")
    public List<Order> myOrder(@PathVariable(value = "id") Integer id) {
        return orderService.myOrder(id);
    }
}
