package com.example.Cart.controler;

import com.example.Cart.dto.CartDto;
import com.example.Cart.dto.CartReturnDto;
import com.example.Cart.entity.Cart;
import com.example.Cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(value ="*")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(value="/cart/{id}")
    public CartReturnDto getCart(@PathVariable("id") Integer id)
    {
        Cart cart= cartService.getCart(id);
        CartReturnDto returnDto=new CartReturnDto();
        BeanUtils.copyProperties(cart,returnDto);
        return  returnDto;
    }

    @DeleteMapping(value="/cart/delete/{userId}/{productId}")
    public CartReturnDto removeCard(@PathVariable("userId") Integer userId, @PathVariable("productId") String productId)
    {

        Cart cart = cartService.removeCard(userId,productId);
        CartReturnDto returnDto=new CartReturnDto();
        BeanUtils.copyProperties(cart,returnDto);
        return  returnDto;

    }

    @PostMapping(value="/cart/add")
    public CartReturnDto addCard(@RequestBody CartDto cartDto)
    {
        Cart cart =  cartService.addCard(cartDto);
        CartReturnDto returnDto=new CartReturnDto();
        BeanUtils.copyProperties(cart,returnDto);
        return  returnDto;
    }


////    @GetMapping(value = "/cart/order/{userId}/{productId}/{quantiti}")
//    public Cart reduceCart(@PathVariable(value = "userId") Integer userId,@PathVariable(value="productId") String productId,@PathVariable(value="quantity") Integer quantity)
//    {
//        return cartService.reduceCart(userId,productId,quantity);
//    }

    @GetMapping(value="/cart/order/{id}")
    public void clearAll(@PathVariable Integer id)
    {
        cartService.clearAll(id);
    }
}
