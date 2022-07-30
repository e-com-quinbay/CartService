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
@CrossOrigin(value ="*")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(value="/cart/{id}")
    public Cart getCart(@PathVariable("id") Integer id)
    {
        return cartService.getCart(id);
    }

    @DeleteMapping(value="/cart/delete/{userId}/{productId}")
    public Cart removeCard(@PathVariable("userId") Integer userId, @PathVariable("productId") String productId)
    {

//        CartDto returnDto=null;
//        BeanUtils.copyProperties(cartService.removeCard(userId,productId),returnDto);
        return cartService.removeCard(userId,productId);

    }

    @PostMapping(value="/cart/add")
    public Cart addCard(@RequestBody CartDto cartDto)
    {
//          Cart cart=new Cart();
//        BeanUtils.copyProperties(cartDto,cart);
          return cartService.addCard(cartDto);
    }
//    @GetMapping(value = "/cart/order/{userId}/{productId}/{quantiti}")
    public Cart reduceCart(@PathVariable(value = "userId") Integer userId,@PathVariable(value="productId") String productId,@PathVariable(value="quantity") Integer quantity)
    {
        return cartService.reduceCart(userId,productId,quantity);
    }
    @GetMapping(value="/cart/order/{id}")
    public void clearAll(@PathVariable Integer id)
    {
        cartService.clearAll(id);
    }
}
