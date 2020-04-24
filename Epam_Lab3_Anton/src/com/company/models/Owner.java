package com.company.models;

import java.util.List;

public class Owner {
    private String name;
    private String location;
    private List<Aircraft> aircraftList;

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Owner(String name, String location) {
        this.name = name;
        this.location = location;
        this.aircraftList = null;
    }
}
