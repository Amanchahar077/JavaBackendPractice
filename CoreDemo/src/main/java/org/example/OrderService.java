package org.example;

import org.example.notification.NotificationService;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public void PlaceOrder(){
        System.out.println("Order Placed!!");
        notification.SendNotification();
    }
}
