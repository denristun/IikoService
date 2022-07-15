package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;

public class Coordinates {

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
