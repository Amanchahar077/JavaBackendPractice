package in.coderArmy;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private OrderService orderService;

    PaymentService(OrderService orderService){
        this.orderService = orderService;
    }

    public void pay(){
        System.out.println("Payment Done");
        orderService.getOrderDetails();
    }


}
