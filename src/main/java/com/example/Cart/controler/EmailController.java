package com.example.Cart.controler;


import com.example.Cart.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@CrossOrigin(value="*")
public class EmailController {


    @Autowired
    private EmailService emailService;

    // Sending a simple Email @GetMapping
    @GetMapping
    public void sendMail()
    {
        String status
                = emailService.sendSimpleMail();

        System.out.println(status);
//        return status;
    }
}
