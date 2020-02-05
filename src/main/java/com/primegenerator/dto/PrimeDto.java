package com.primegenerator.dto;

import javax.validation.constraints.NotNull;

public class PrimeDto {

    @NotNull(message = "Username must be a string")
    private String username;

    @NotNull(message = "Selection must be an integer")
    private int selection;
    private int startValue;
    private int stopValue;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getStopValue() {
        return stopValue;
    }

    public void setStopValue(int stopValue) {
        this.stopValue = stopValue;
    }
}
