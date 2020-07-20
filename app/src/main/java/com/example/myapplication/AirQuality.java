package com.example.myapplication;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class AirQuality extends Status {

    public ArrayList<Gas> gases;
    //TODO- account for smoke variable in status calculation
    private boolean smoke;


    public AirQuality(){
        super();
        gases = new ArrayList<Gas>();
        //TODO- Remember to consider time!!
        gases.add(new Gas("CarbonMonoxide",35, 50));
        gases.add(new Gas("Methane",1000, 50000));
        gases.add(new Gas("Propane",17000, 23000));
        smoke = false;
        //CO (Ganna), Smoke (Ravin), Propane (Vida), Methane (Robin)
    }


    public void update(){
        //TODO- Pull readings from cloud, update readings
        double currentReading = 0;
        //this will get concentration readings from air quality sensor and update accordingly
    }


    @Override
    public void refresh() {
        int max = 0;
        for(Gas g: gases){
            if(g.getGasStatus() > max)
                max = g.getGasStatus();
        }
        if(smoke)
            max = 3;
        setStatus(max);
    }

    public void setSmoke(int i){
        if(i == 1)
            smoke = true;
        else
            smoke = false;
    }

    public String toString(){
        String s = "";
        for(Gas g : gases){
            if(g.lastTenReadings.size() > 0){
                s = s + g.getName() + ": " + g.lastTenReadings.get(g.lastTenReadings.size() - 1) + "  |  ";
            }
        }
        s = s + "Smoke: " + smoke + "\n";
        return s;
    }


}
