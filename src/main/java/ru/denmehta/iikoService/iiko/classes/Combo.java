package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;

public class Combo {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private int amount;

    @NotNull
    private double price;

    @NotNull
    private String sourceId;

    @NotNull
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
