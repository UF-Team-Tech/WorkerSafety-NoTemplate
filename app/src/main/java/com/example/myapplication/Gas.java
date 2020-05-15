package com.example.myapplication;

import java.util.ArrayDeque;
import java.util.Queue;

public class Gas {
    private String name;
    private ArrayDeque<Double> lastTenReadings;
    private final double yellowThreshold, redThreshold;
    private double timeExposed;

    public Gas(String name, double y, double r){
        this.name = name;
        yellowThreshold = y;
        redThreshold = r;
        timeExposed = 0;
        lastTenReadings = new ArrayDeque<Double>();
    }

    public double getYellowThreshold() {
        return yellowThreshold;
    }

    public double getRedThreshold() {
        return redThreshold;
    }

    public String getName() {
        return name;
    }

    public double getTimeExposed() {
        return timeExposed;
    }

    public void setTimeExposed(double timeExposed) {
        this.timeExposed = timeExposed;
    }

    public double getChange(){
        //Calculate change in 10 values, see if it is beyond thresholds
        //Possibly percentage change, rate of change, catch fluctuations in data
        //Predict danger zones (next reading is going to trigger signal)
        return 0;
    }

    public int getGasStatus(){
        double result = getChange();
        //TODO- if getChange() is strange, return 0 (unknown)
        if(lastTenReadings.peek() >= redThreshold) {
            return 3; //red
        }
        else if(lastTenReadings.peek() >= yellowThreshold) {
            return 2; //yellow
        }
        else
            return 1; //green
    }



}
