package edu.cscc.designpatterns.factory;

public class RoboticDuck implements Duck {

    private Wings wings;
    private Bill bill;
    private WebbedFeet webbedFeet;
    private String coloration;

    public RoboticDuck(Wings wings, Bill bill, WebbedFeet webbedFeet, String coloration) {
        this.wings = wings;
        this.bill = bill;
        this.webbedFeet = webbedFeet;
        this.coloration = coloration;
    }

    @Override
    public String quack() {
        return bill.makeNoise();
    }
}
