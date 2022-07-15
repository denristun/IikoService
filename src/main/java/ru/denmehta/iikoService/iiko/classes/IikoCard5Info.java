package ru.denmehta.iikoService.iiko.classes;

import java.util.ArrayList;

public class IikoCard5Info {

    private String coupon;

    private ArrayList<String> applicableManualConditions;

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public void setApplicableManualConditions(ArrayList<String> applicableManualConditions) {
        this.applicableManualConditions = applicableManualConditions;
    }
}
