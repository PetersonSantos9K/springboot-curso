package com.github.PetersonSantos9K.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExampleValue {

    @Value("${app.config.variable}")
    private String variable;

    public void imprimirVariavel(){
        IO.println(variable);
    }
}
