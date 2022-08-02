package com.example.Cart.service;

import com.example.Cart.dto.CartDto;
import com.example.Cart.dto.ProductDto;
import com.example.Cart.entity.Cart;
import com.example.Cart.entity.CartArray;
import com.example.Cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    UtilService utilService;


    public Cart getCart(@PathVariable("id") Integer id)
    {
     return  cartRepository.findByUserId(id);
    }


    public Cart removeCard(Integer userId,String productId)
    {
        Cart cart=cartRepository.findByUserId(userId);
        double total=cart.getAmount();
        System.out.println(cart);
         List<CartArray> productList=cart.getCard();
//        System.out.println(productList);
        for(int i=0;i<productList.size();i++)
        {
            if(productList.get(i).getProduct().getId().equals(productId))
            {
                total-=(productList.get(i).getProduct().getPrice()*productList.get(i).getQuantity());
                productList.remove(i);
                break;
            }
        }
//        System.out.println(productList);
          cart.setAmount(total);
         cart.setCard(productList);
         cartRepository.save(cart);

        return getCart(userId);
    }


    public Cart addCard(CartDto cart)
    {
         Cart newCart=cartRepository.findByUserId(cart.getUserId());

         System.out.println(cart);

         if(newCart!=null) {
            int f=0;
            List<CartArray> productList =newCart.getCard();
             double total=newCart.getAmount();
//            System.out.println(productList+"\n\n");
            for (int index=0;index<productList.size();index++) {


                if (productList.get(index).getProduct().getId().equals(cart.getProductId()))
                 {
                    f=1;
                    int qnty=productList.get(index).getQuantity() + cart.getQuantity();
//                    System.out.println(qnty);
                    if(utilService.checkForStock(cart.getProductId(),qnty)&&qnty>-1) {
                        total=total+(cart.getQuantity()*getProduct(cart.getProductId()).price);
                        productList.get(index).setQuantity(qnty);
                        if (productList.get(index).getQuantity() == 0)
                            productList.remove(index);
                    }
                    else
                        return null;
                 }
            }
             if(f==0) {
                 CartArray array = new CartArray();
                 array.setProduct(getProduct(cart.getProductId()));
                 array.setQuantity(cart.getQuantity());
                 productList.add(array);
                 total=total+(cart.getQuantity()*getProduct(cart.getProductId()).price);
             }
            newCart.setCard(productList);
            newCart.setAmount(total);
            cartRepository.save(newCart);
            System.out.println(newCart);
             return getCart(cart.getUserId());
        }

           CartArray array = new CartArray();
           array.setProduct(getProduct(cart.getProductId()));
           array.setQuantity(cart.getQuantity());
           double total=array.getProduct().getPrice()*cart.getQuantity();
            Cart newCart1 = new Cart();

            newCart1.setUserId(cart.getUserId());
            newCart1.setCard(new ArrayList<>());
            newCart1.getCard().add(array);
            newCart1.setAmount(total);

            System.out.println(newCart1);

            cartRepository.save(newCart1);

         return getCart(cart.getUserId());

    }

    public void clearAll(Integer id)
    {

         cartRepository.deleteById(id);
//        Cart newCart=cartRepository.findByUserId(id);
//        List<CartArray> productList =newCart.getCard();
//        productList.clear();
//        newCart.setCard(productList);
//        cartRepository.save(newCart);
    }

//     public Cart reduceCart(Integer userId,String productId,Integer quantity)
//        {
//                CartDto cart=new CartDto();
//                cart.setProductId(productId);
//                cart.setUserId(userId);
//                cart.setQuantity(-quantity);
//                addCard(cart);
//            return getCart(userId);
//        }

      public ProductDto getProduct(String id)
      {
          String url="http://10.20.3.120:8080/product/";
          RestTemplate restTemplate=new RestTemplate();
          return restTemplate.getForObject(url+id,ProductDto.class);
      }
}
