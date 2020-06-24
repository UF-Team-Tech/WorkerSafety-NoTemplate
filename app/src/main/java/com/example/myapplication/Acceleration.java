package com.example.myapplication;

public class Acceleration extends Status {

    private double maxAcceleration;

    public Acceleration(double d){
        super();
        maxAcceleration = d;
    }

    @Override
    public void refresh() {
        double ab = Math.abs(maxAcceleration);
        if(ab >= 0 && ab < 5){
            setGreen(true);
        }
        else if(ab >=5 && ab < 10){
            setYellow(true);
        }
        else {
            setRed(true);
        }
    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    public void setMaxAcceleration(double maxAcceleration) {
        this.maxAcceleration = maxAcceleration;
    }
}
