package com.example.Cart.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UtilService {

    public Boolean checkForStock(Integer productId,Integer quantity)
    {
        String url="";
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(url+productId+"/"+quantity,Boolean.class);
    }
    public Boolean decreaseStock(Integer productId,Integer quantity)
    {
        String url="";
        RestTemplate restTemplate=new RestTemplate();
        int updatedQnty= restTemplate.getForObject(url+productId+"/"+quantity,Integer.class);
        if(updatedQnty<quantity)
            return true;
        return false;
    }
}
