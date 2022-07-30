package com.example.Cart.service;

import com.example.Cart.entity.Cart;
import com.example.Cart.entity.CartArray;
import com.example.Cart.entity.CartReturn;
import com.example.Cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    UtilService utilService;


    public Cart getCart(@PathVariable("id") Integer id)
    {
        Cart cart= cartRepository.findByUserId(id);
//        String url="";
//        RestTemplate restTemplate=new RestTemplate();
//        return restTemplate.postForObject(url,cart.getCard(),CartReturn.class);
        return  cart;
    }


    public CartReturn removeCard(Integer userId,String productId)
    {
        Cart cart=cartRepository.findByUserId(userId);

         List<CartArray> productList=cart.getCard();
//        System.out.println(productList);
        for(int i=0;i<productList.size();i++)
        {
            if(productList.get(i).getProductId().equals(productId))
            {
                if(productList.get(i).getQuantity()==1)
                    productList.remove(i);
                else
                    productList.get(i).setQuantity(productList.get(i).getQuantity()-1);
                break;
            }
        }
//        System.out.println(productList);
         cart.setCard(productList);
         cartRepository.save(cart);

//        return getCart(userId);
        return null;
    }


    public CartReturn addCard(Cart cart)
    {
         Cart newCart=cartRepository.findByUserId(cart.getUserId());

         if(newCart!=null) {
            int f=0;
            List<CartArray> productList =newCart.getCard();
//            System.out.println(productList+"\n\n");
            for (int index=0;index<productList.size();index++) {


                if (productList.get(index).getProductId().equals(cart.getCard().get(0).getProductId()))
                 {
                    f=1;
                    int qnty=productList.get(index).getQuantity() + cart.getCard().get(0).getQuantity();
//                    if(utilService.checkForStock(cart.getCard().get(0).getProductId(),qnty)) {
                        productList.get(index).setQuantity(qnty);
                        if (productList.get(index).getQuantity() == 0)
                            productList.remove(index);
//                    }
//                    else
//                        return null;
                 }
            }
            if(f==0)
            productList.add(cart.getCard().get(0));
            cart.setCard(productList);
            cartRepository.save(cart);
        }
            cartRepository.save(cart);
//         return getCart(cart.getUserId());
            return null;
    }

    public void clearAll(Integer id)
    {
        Cart newCart=cartRepository.findByUserId(id);
        List<CartArray> productList =newCart.getCard();
        productList.clear();
        newCart.setCard(productList);
        cartRepository.save(newCart);
    }

     public void reduceCart(Integer userId,String productId,Integer quantity)
        {
            Cart cart=cartRepository.findByUserId(userId);
            List<CartArray> productList=cart.getCard();
            CartArray newCart=new CartArray();
            newCart.setProductId(productId);
            newCart.setQuantity(-quantity);
            productList.clear();
            productList.add(newCart);
            addCard(cart);
        }
}
