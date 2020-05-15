package com.example.myapplication;

public class Worker {
    //workerID, first name, last name
    private String workerID, firstname, lastname;
    //latitude, longitude
    private double latitude, longitude;
    //status: air quality and acceleration (Status class objects

    //birthday
    //phone number
    //email

    public Worker(String w, String first, String last, double lat, double lon){
        workerID = w;
        firstname = first;
        lastname = last;
        latitude = lat;
        longitude = lon;
    }

    public String getWorkerID(){
        return workerID;
    }

    public void setWorkerID(String w){
        this.workerID = w;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String f){
        this.firstname = f;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
