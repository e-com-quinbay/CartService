package com.example.Cart.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient="arunkumarc0610@gmail.com";
    private String msgBody="Order Placed";
    private String subject="Order Mail";
}