package com.BROPATING.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    private Vehical veh;

//    Contructor injector
    @Autowired
    public Dev(@Qualifier("bike") Vehical veh){
        this.veh = veh;
    }

//  Setter Injector
//    @Autowired
//    public void setVeh(Vehical veh) {   // Setter injection
//        this.veh = veh;
//    }

    public void race(){
        veh.run();
    }
}
