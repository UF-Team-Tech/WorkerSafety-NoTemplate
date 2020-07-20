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

    public void setStatus(int max){
        if(max == 3) {
            currentStatus = "Red";
            red = true;
            yellow = false;
            green = false;
        }
        else if(max == 2) {
            currentStatus = "Yellow";
            yellow = true;
            red = false;
            green = false;
        }
        else if(max == 0){
            currentStatus = "Green";
            green = true;
            red = false;
            yellow = false;
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
