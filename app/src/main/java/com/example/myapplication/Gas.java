package com.example.myapplication;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Gas {
    private String name;
    public ArrayList<Double> lastTenReadings;
    private final double yellowThreshold, redThreshold;
    private double timeExposed;

    public Gas(String name, double y, double r){
        this.name = name;
        yellowThreshold = y;
        redThreshold = r;
        timeExposed = 0;
        lastTenReadings = new ArrayList<Double>();
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

    public void addNewSensorValue(double val){
        if(lastTenReadings.size() == 10){
            lastTenReadings.remove(0);
        }
        lastTenReadings.add(val);
    }

    public boolean isRapidlyIncreasing(){
        //Calculate change in last 3 values, see if it is beyond thresholds
        if(lastTenReadings.size() < 3)
            return false;
        int len = lastTenReadings.size();
        double old = lastTenReadings.get(len - 3);
        double ish = lastTenReadings.get(len - 2);
        double  new1 = lastTenReadings.get(len - 1);
        double sum = (new1 - ish) / ish + (ish - old) / old; //this is the sum of the last two percentage changes
        if(new1 > (yellowThreshold / 2.0) && sum > 0.5) //where 0.5 is considered a large percent increase
            return true;
        else
            return false;
    }

    public int getGasStatus(){
        int len = lastTenReadings.size();
        if(len <= 0){
            return 0;
        }
        if(lastTenReadings.get(len - 1) >= redThreshold) {
            return 3; //red
        }
        else if(lastTenReadings.get(len - 1) >= yellowThreshold) {
            return 2; //yellow
        }
        else if(isRapidlyIncreasing())
            return 1; //warning
        else
            return 0; //green
    }




}
