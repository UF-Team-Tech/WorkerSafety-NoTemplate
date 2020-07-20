package com.example.myapplication;

public class ListStuff {
    private String city;
    private String stateProvince;
    public ListStuff(String city, String stateProvince) {
        this.city = city;
        this.stateProvince = stateProvince;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateProvince() {
        return stateProvince;
    }
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
}