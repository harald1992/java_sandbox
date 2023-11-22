package com.harald.SpringCore.classes;

import com.harald.SpringCore.interfaces.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary    // set as primary so autowired gets this one first
public class Tiger implements Animal {

    public Tiger() {
        System.out.println("CLASS " + getClass().getSimpleName() + " created!");
    }

    @Override
    public String makeSound() {
        return "Grrr";
    }

}
