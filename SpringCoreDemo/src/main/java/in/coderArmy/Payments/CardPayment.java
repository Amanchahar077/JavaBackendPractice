package in.coderArmy.Payments;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("card")
public class CardPayment implements PaymentService {

    @Override
    public void pay(){
        System.out.println("Paid via Card!!");
    }
}
