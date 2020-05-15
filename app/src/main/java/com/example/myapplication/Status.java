package com.example.myapplication;

public abstract class Status {
    private boolean red;
    private boolean yellow;
    private boolean green;
    private String currentStatus;

    public Status(){
        red = false;
        yellow = false;
        green = false;
        currentStatus = "Unknown";
    }

    public void setStatus(){
        if(red) {
            currentStatus = "Red";
        }
        else if(yellow) {
            currentStatus = "Yellow";
        }
        else if(green){
            currentStatus = "Green";
        }
        else {
            currentStatus = "Unknown";
        }
    }

    public abstract void refresh();


    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public boolean isYellow() {
        return yellow;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }
}
