package org.example.notification;

public class EmailNotification implements SendNotification {

    @Override
    public void SendNotification(){
        System.out.println("Email is Sent!!");
    }
}
