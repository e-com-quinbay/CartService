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
    public CartReturn removeCard(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId)
    {

//        CartDto returnDto=null;
//        BeanUtils.copyProperties(cartService.removeCard(userId,productId),returnDto);
        return cartService.removeCard(userId,productId);

    }

    @PostMapping(value="/cart/add")
    public CartReturn addCard(@RequestBody Cart cartDto)
    {
//          Cart cart=new Cart();
//        BeanUtils.copyProperties(cartDto,cart);
          return cartService.addCard(cartDto);
    }
//    @GetMapping(value = "/cart/order/{userId}/{productId}/{quantiti}")
    public void reduceCart(@PathVariable(value = "userId") Integer userId,@PathVariable(value="productId") Integer productId,@PathVariable(value="quantity") Integer quantity)
    {
        cartService.reduceCart(userId,productId,quantity);
    }
    @GetMapping(value="/cart/order/{id}")
    public void clearAll(@PathVariable Integer id)
    {
        cartService.clearAll(id);
    }
}
