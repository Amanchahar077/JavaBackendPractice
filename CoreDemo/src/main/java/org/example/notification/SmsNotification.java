package org.example.notification;

public class SmsNotification implements SendNotification {

    @Override
    public void SendNotification(){
        System.out.println("Sms Sent!!");
    }
}
