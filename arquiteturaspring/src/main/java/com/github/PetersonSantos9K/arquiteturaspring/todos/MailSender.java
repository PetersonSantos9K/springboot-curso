package com.github.PetersonSantos9K.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {


    public void enviar(String mensagem){
        IO.println("Enviando email: " + mensagem);
    }

}
