package com.example.Cart.service;

import com.example.Cart.entity.Cart;
import com.example.Cart.entity.CartArray;
import com.example.Cart.entity.CartReturn;
import com.example.Cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.where;


import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Cart> getCart(@PathVariable("id") Integer id)
    {
        return cartRepository.findByUserId(id);
//        String url="";
//        RestTemplate restTemplate=new RestTemplate();
//        return restTemplate.postForObject(url,cart.getCard(),CartReturn.class);
    }


    public void removeCard(@PathVariable("userId") Integer userId,@PathVariable("productId") Integer productId)
    {
        List<Cart> cart=cartRepository.findByUserId(userId);

        //function for remove card
//        List<CartArray> productList=cart.getCard();
//
//        for(int i=0;i<productList.size();i++)
//        {
//            if(productList.get(i).getProductId()==productId)
//            {
//                if(productList.get(i).getQuantity()==1)
//                    productList.remove(i);
//                else
//                    productList.get(i).setQuantity(productList.get(i).getQuantity()-1);
//            }
//        }
//        cart.setCard(productList);
//        cartRepository.save(cart);

//        return getCart(userId);
    }


    public void addCard(Cart cart)
    {
//        Cart cart1=cartRepository.findByUserId(cart.getUserId());
//        List<CartArray> productList=cart1.getCard();
//        for(CartArray index :productList)
//        {
//            if(index.getProductId()==cart.getCard().get(0).getProductId())
//            {
//                index.setQuantity(index.getQuantity()+cart.getCard().get(0).getQuantity());
//            }
//        }
//        cart1.setCard(productList);
//        cartRepository.save(cart);
        if(getCart(cart.getUserId()).size()>0)
        {
            Update update = new Update();
            update.addToSet("card", cart.getCard());
            Criteria criteria = where("userId").is(cart.getUserId());
            mongoTemplate.updateFirst(Query.query(criteria), update, "cart");
        }
        else
        {
            cartRepository.save(cart);
        }
    }
}
