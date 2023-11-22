package com.harald.SpringCore.classes;

import com.harald.SpringCore.interfaces.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
// @Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Chicken implements Animal {

    @Override
    public String makeSound() {
        return "Pok Pok Pok";
    }

    @PostConstruct
    private void onInit() {
        System.out.println("Chicken created");
    }

    @PreDestroy
    public void OnDestroy() {
        System.out.println("Chicken bean destroyed");
    }

}
