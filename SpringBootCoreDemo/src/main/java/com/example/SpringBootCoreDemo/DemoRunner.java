package com.example.SpringBootCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner /*ApplicationRunner*/ {

    private PaymentGateway paymentgateway;

    @Autowired
    public DemoRunner(PaymentGateway paymentgateway){
        this.paymentgateway = paymentgateway;
    }

    @Override
    public void run(String... args) throws Exception {
        paymentgateway.print();
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        paymentgateway.print();
//    }
}
