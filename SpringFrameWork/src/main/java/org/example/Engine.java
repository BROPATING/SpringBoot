package org.example;

public class Engine {
    private Vehical veh;

    private int km;

    public void setKilometers(int km){
        this.km = km;
    }

    public void setVehical(Vehical veh) {
        this.veh = veh;
    }

    public void start(){
        System.out.println("Engine is starting ...");
        System.out.println("Running Km "+km);
        veh.run();
    }

    public Engine(){

    }
//     Multi-parameter constructor matching your notes
    public Engine(int km, Vehical vehical) {
        this.km = km;
        this.veh = vehical;
    }
}
