package com.example.Cart.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UtilService {

    public Boolean checkForStock(String productId,Integer quantity)
    {
        String url="http://://";
        RestTemplate restTemplate=new RestTemplate();
        Integer avail= restTemplate.getForObject(url+productId+"/"+quantity,Integer.class);
        if(avail<quantity)
            return false;
        return true;
    }
    public Boolean decreaseStock(String productId,Integer quantity)
    {
        String url="http://://";
        RestTemplate restTemplate=new RestTemplate();
        int updatedQnty= restTemplate.getForObject(url+productId+"/"+quantity,Integer.class);
        if(updatedQnty<quantity)
            return true;
        return false;
    }
}
