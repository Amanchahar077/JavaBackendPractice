package in.coderArmy;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CartService implements InitializingBean, DisposableBean {

    public HashMap<Integer,String> map;

//    @Autowired
    public CartService(){
        map = new HashMap<>();
        System.out.println("CartService Constructor called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization Interface called");
        map.put(1,"Aman");
        map.put(2,"Suraj");
    }

    @PostConstruct
    public void start2(){
        System.out.println("PostConstruct called");
        map.put(1,"Aman");
        map.put(2,"Suraj");
    }

    public void start(){
        System.out.println("INIT called");
        map.put(1,"Aman");
        map.put(2,"Suraj");
    }

    public void addToCart(){
        System.out.println("Added to cart");
    }

    public String getValue(int key){
        return map.get(key);
    }

    @Override
    public void destroy() throws Exception {
        map.clear();
        System.out.println("Bean Destroyed");
    }
}
