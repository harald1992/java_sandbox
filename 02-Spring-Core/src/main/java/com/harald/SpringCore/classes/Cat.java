package com.harald.SpringCore.classes;

import com.harald.SpringCore.interfaces.Animal;
import org.springframework.context.annotation.Bean;

public class Cat implements Animal {

    @Override
    public String makeSound() {
        return "Meow";
    }

}
