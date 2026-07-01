package com.BROPATING.SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehical{
    public Bike(){
        System.out.println("On Bike ...!!!...");
    }
    public void run(){
        System.out.println("Running in Bike");
    }
}
