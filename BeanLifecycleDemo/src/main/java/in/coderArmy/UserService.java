package in.coderArmy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("userBean")
public class UserService implements BeanNameAware {

    @Autowired
    UserService(){
        System.out.println("UserService is Called");
    }

    @Override
    public void setBeanName(String name){
        System.out.println("Bean name: "+name);
    }

}
