package com.example.Cart.service;

import com.example.Cart.dto.ProductDto;
import com.example.Cart.entity.Cart;
import com.example.Cart.entity.CartArray;
import com.example.Cart.entity.CartReturn;
import com.example.Cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    MongoOperations mongoOperation;

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
//        cartRepository.sav

        Cart newCart=cartRepository.findByUserId(cart.getUserId());

        List<CartArray> cartArray = newCart.getCard();

        if(cartArray.size()>0) {
            int f=0;
//            List<CartArray> productList = cart1.get(0).getCard();
//            for (CartArray index : productList) {
//
//
//                if (index.getProductId() == cart.getCard().get(0).getProductId())
//                 {
//                    f=1;
//                    index.setQuantity(index.getQuantity() + cart.getCard().get(0).getQuantity());
//                     }
//            }

            if(cartArray.contains(cart.getCard().get))

            if(f==1)
                productList.add(cart.getCard().get(0));

            cart.setCard(productList);
//            System.out.println(cart);
            cartRepository.save(cart);


//            {//            Query query = new Query();
////            query.addCriteria(Criteria.where("userId").is(cart.getUserId()));
//////            query.fields().include("userId");
////
////            Cart userTest2 = mongoOperation.findOne(query, Cart.class);
////            System.out.println(userTest2);
////            List<CartArray> a=userTest2.getCard();
////
////            System.out.println(a);
////            a.add(cart.getCard().get(0));
////            System.out.println(a);
//////            userTest2.setCard(a);
//////            System.out.println(userTest2);
//////            mongoOperation.save(userTest2);
////            Update update = new Update();
////            update.set("card", a);
////            mongoTemplate.updateFirst(query,update,"cart");}
        }
        cartRepository.save(cart);
////        if(getCart(cart.getUserId()).size()>0)
////        {
////            Update update = new Update();
////            update.addToSet("card", cart.getCard());
////            Criteria criteria = where("userId").is(cart.getUserId());
////            mongoTemplate.updateFirst(Query.query(criteria), update, "cart");
////        }
////        else
////        {
////            cartRepository.save(cart);
////        }
//        Query query = new Query();
//        query.addCriteria(Criteria.where("userId").is(cart.getUserId()));
//        query.fields().include("userId");
//        Cart userTest2 = mongoOperations.findOne(query, Cart.class);
//        System.out.println("userTest2 - " + userTest2);
//
//        CartArray[] a=userTest2.getCard();
//        a[a.size]

    }


    public void addToCart(@RequestBody ProductDto productDto)
    {
        int id = productDto.id;



    }
}
