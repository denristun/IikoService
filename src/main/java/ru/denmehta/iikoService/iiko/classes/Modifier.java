package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;

public class Modifier {

    @NotNull
    private String productId;

    @NotNull
    private double amount;

    private String productGroupId;

    private double price;

    private String positionId;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setProductGroupId(String productGroupId) {
        this.productGroupId = productGroupId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}
