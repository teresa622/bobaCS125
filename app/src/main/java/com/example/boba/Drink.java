package com.example.boba;

import java.io.Serializable;

public class Drink implements Serializable {
    private String name;
    private String time;
    public Drink(String setName, String setTime) {
        name = setName;
        time = setTime;
    }
    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
}
