package com.example.Cart.service;


import com.example.Cart.dto.ProductDto;
import com.example.Cart.entity.*;
import com.example.Cart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UtilService utilService;
    @Autowired
    CartService cartService;
    @Autowired
    EmailService emailService;

     public Order order(Order order)
    {
//        if(utilService.checkForStock(order.getProducts().get(0).getProductId(),order.getProducts().get(0).getQuantity())) {
            order.setId(idGenerate() + 1);
            order.setTotal(order.getProducts().get(0).getPrice()*order.getProducts().get(0).getQuantity());
            order.getProducts().get(0).setImage(getProduct(order.getProducts().get(0).getProductId()).getImage());
//            order.se
//            if(utilService.decreaseStock(order.getProducts().get(0).getProductId(),order.getProducts().get(0).getQuantity()))
//             System.out.println(order);
              emailService.sendSimpleMail();
              return orderRepository.save(order);
//            return true;
//        }
//        return false;
    }

    public Order orderCart(Cart cart)
    {
        Order order=new Order();
        order.setId(idGenerate()+1);
        order.setUserId(cart.getUserId());
        order.setTotal(cart.getAmount());
        List<CartArray> array=cart.getCard();
        order.setProducts(new ArrayList<>());
        for(int i=0;i<array.size();i++)
        {
            OrderList item=new OrderList();
            item.setProductId(array.get(i).getProduct().getId());
            item.setProductName(array.get(i).getProduct().getName());
            item.setPrice(array.get(i).getProduct().getPrice());
            item.setQuantity(array.get(i).getQuantity());
            item.setImage(array.get(i).getProduct().getImage());
            order.getProducts().add(item);
        }

        orderRepository.save(order);
        cartService.clearAll(cart.getUserId());
        emailService.sendSimpleMail();
        return orderRepository.findById(idGenerate());
    }

    public ProductDto getProduct(String id)
    {
        String url="http://10.20.3.120:8080/product/";
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(url+id,ProductDto.class);
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

