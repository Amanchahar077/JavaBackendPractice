package com.example.SpringBootCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private PaymentProperties paymentProperties;

    @Autowired
    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }


    public int getCount() {
        return paymentProperties.getCount();
    }


    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }


    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getCount());
        System.out.println(getTimeout());
        System.out.println(isEnabled());
    }




















    //    private String paymentType;
//    private int retryCount;

//    public PaymentGateway(@Value("${PaymentGateway.payment-Type:RazorPay}") String paymentType,
//                          @Value("${PaymentGateway.retry-Count:3}") int retryCount) {
//        this.paymentType = paymentType;
//        this.retryCount = retryCount;
//    }
//
//    public String getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(String paymentType) {
//        this.paymentType = paymentType;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }
}
