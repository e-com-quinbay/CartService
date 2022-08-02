package com.example.Cart.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UtilService {

    public Boolean checkForStock(String productId,Integer quantity)
    {
        String url="http://10.20.3.120:8084/availableStock/";
        RestTemplate restTemplate=new RestTemplate();
        Integer avail= restTemplate.getForObject(url+productId,Integer.class);
        System.out.println("available "+avail);
        if(avail<quantity)
            return false;
        return true;
    }
    public Boolean decreaseStock(String productId,Integer quantity)
    {
        String url="http://10.20.3.120:8084/decreaseStock/";
        RestTemplate restTemplate=new RestTemplate();
        int updatedQnty= restTemplate.getForObject(url+productId+"/"+quantity,Integer.class);
        System.out.println("available "+updatedQnty);
        if(updatedQnty<updatedQnty+quantity) {
            System.out.println("true");
            return true;
        }
        return false;
    }
}
