package com.example.myapplication;

public class ListStuff {
    private String workerid, firstname, lastname, status;

    public ListStuff(String workerid, String firstname, String lastname, String status) {
        this.workerid = workerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
    }

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}