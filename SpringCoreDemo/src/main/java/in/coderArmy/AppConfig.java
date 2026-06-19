package in.coderArmy;

import in.coderArmy.Payments.PaymentService;
import in.coderArmy.Payments.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.coderArmy")
public class AppConfig {

    @Bean
    public User createUser(){
        return new User("Aditya",23);
    }

    @Bean
    public PaymentService upiBean(){
        return new UpiPayment();
    }

    @Bean
    public OrderService orderService(PaymentService paymentService){
        return new OrderService(paymentService);
    }
}
