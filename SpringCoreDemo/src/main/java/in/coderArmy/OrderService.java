package in.coderArmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired //not recommended
    private PaymentService paymentService;

    @Autowired //Recommended
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
//
//    @Autowired //not recommended
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void order(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
