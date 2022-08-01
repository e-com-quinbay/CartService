package com.example.Cart.controler;


import com.example.Cart.dto.OrderDto;
import com.example.Cart.entity.Cart;
import com.example.Cart.entity.Order;
import com.example.Cart.service.CartService;
import com.example.Cart.service.OrderService;
import org.springframework.beans.BeanUtils;
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
    public OrderDto order(@RequestBody OrderDto orderDto)
    {
//        System.out.println(orderDto);

        Order order=new Order();
        BeanUtils.copyProperties(orderDto,order);
//        System.out.println(order);
        order= orderService.order(order);
        if(order!=null) {
            OrderDto returnDto;
            BeanUtils.copyProperties(order, orderDto);
            return orderDto;
        }
        return null;
    }



    @GetMapping(value="/cart/{id}")
    public  OrderDto orderCart(@PathVariable(value="id") Integer id)
    {
        Cart cart=cartService.getCart(id);
        Order order= orderService.orderCart(cart);
        OrderDto returnDto=new OrderDto();
        BeanUtils.copyProperties(order,returnDto);
        return  returnDto;
    }


    @GetMapping(value = "/myorder/{id}")
    public List<Order> myOrder(@PathVariable(value = "id") Integer id) {
        return orderService.myOrder(id);
    }
}
