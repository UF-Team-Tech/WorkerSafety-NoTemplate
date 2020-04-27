package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class AirQuality extends Status {

    private HashMap<String, ArrayList<Double>> concentrations;


    public AirQuality(){
        super();
        concentrations = new HashMap<String, ArrayList<Double>>();
        //initialize known thresholds for danger
        //CO (Ganna), Smoke (Ravin), Propane (Vida), Methane (Robin)
    }

    public void update(){
        //this will get concentration readings from air quality sensor and update accordingly
    }


    @Override
    public void refresh() {

    }

    //make


}
