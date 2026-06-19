package in.coderArmy;

import in.coderArmy.Payments.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
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

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
