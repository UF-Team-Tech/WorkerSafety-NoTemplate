package com.example.myapplication;

public class Person {
    //workerID
    private String workerId;
    //the company would set the id upon input of the worker
    private String lastName;


    public Person(String workerId, String lastName) {
        this.lastName = lastName;
        this.workerId = workerId;
    }

    //string would be passed into constructor
    //Name, last name, first name by string
    //Latitude, Longitude
    //status (dropdown, air quality, acceleration)
    //Happy B-day
    //Phone Number
    //email

    public String getWorker()
    {
        return workerId;
    }

    public void setWorker(String workerId)
    {
        this.workerId = workerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
