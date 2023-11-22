package com.harald.SpringCore.controllers;

import com.harald.SpringCore.interfaces.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AnimalController {

    @Autowired
    private Animal tiger;

    @Autowired
    @Qualifier("chicken")
    private Animal animal;

    @Autowired
    @Qualifier("cat")
    private Animal cat;


    @GetMapping("/tiger")
   public String bark() {
        return tiger.makeSound();
    }

    @GetMapping("/chicken")
    public String cackle() {
        return animal.makeSound();
    }

    @GetMapping("/cat")
    public String meow() {
        return cat.makeSound();
    }
}
