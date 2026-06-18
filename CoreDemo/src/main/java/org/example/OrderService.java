package org.example;

import org.example.notification.EmailNotification;
import org.example.notification.PopNotification;
import org.example.notification.SendNotification;
import org.example.notification.SmsNotification;

public class OrderService {

    SendNotification smsNotification = new SmsNotification();
    SendNotification popNotification = new PopNotification();
    SendNotification emailNotification = new EmailNotification();


    public void PlaceOrder(){
        System.out.println("Order Placed!!");
        popNotification.SendNotification();
    }
}
