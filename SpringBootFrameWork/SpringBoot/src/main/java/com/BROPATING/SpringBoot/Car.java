package com.BROPATING.SpringBoot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehical{
    public Car(){
        System.out.println("On Car ...!!!...");
    }
    public void run(){
        System.out.println("Running in Car");
    }
}
