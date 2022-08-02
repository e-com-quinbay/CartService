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
        System.out.println(cart);
        if(cart!=null) {
            CartReturnDto returnDto = new CartReturnDto();
            BeanUtils.copyProperties(cart, returnDto);
            return returnDto;
        }
        return null;
    }

    @DeleteMapping(value="/cart/remove/{userId}/{productId}")
    public CartReturnDto removeCard(@PathVariable("userId") Integer userId, @PathVariable("productId") String productId)
    {
        System.out.println(userId);
        Cart cart = cartService.removeCard(userId,productId);
        System.out.println(cart);
        if(cart!=null) {
            CartReturnDto returnDto = new CartReturnDto();
            BeanUtils.copyProperties(cart, returnDto);
            System.out.println(returnDto);
            return returnDto;
        }

        return null;

    }

    @PostMapping(value="/cart/add")
    public CartReturnDto addCard(@RequestBody CartDto cartDto)
    {
        Cart cart =  cartService.addCard(cartDto);

        if(cart!=null) {
            CartReturnDto returnDto = new CartReturnDto();
            BeanUtils.copyProperties(cart, returnDto);
            return returnDto;
        }
        return null;
    }


    @GetMapping(value="/cart/clear/{id}")
    public void clearAll(@PathVariable Integer id)
    {
        cartService.clearAll(id);
    }
}
