package com.example.Cart.controler;

import com.example.Cart.dto.CartDto;
import com.example.Cart.entity.Cart;
import com.example.Cart.entity.CartReturn;
import com.example.Cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(value="/cart/{id}")
    public Cart getCart(@PathVariable("id") Integer id)
    {
        return cartService.getCart(id);
    }

    @DeleteMapping(value="/cart/delete/{userId}/{productId}")
    public CartDto removeCard(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId)
    {

        CartDto returnDto=null;
//        BeanUtils.copyProperties(cartService.removeCard(userId,productId),returnDto);
        return returnDto;
    }

    @PostMapping(value="/cart/add")
    public void addCard(@RequestBody Cart cartDto)
    {
          Cart cart=new Cart();
//        BeanUtils.copyProperties(cartDto,cart);
          cartService.addCard(cartDto);
    }
}
