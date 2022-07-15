package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;
import ru.denmehta.iikoService.iiko.enums.DiscountType;

import java.util.ArrayList;

public class Discount {

    @NotNull
    private String discountTypeId;

    private double sum;

    private ArrayList<String> selectivePositions;

    @NotNull
    private DiscountType type;


    public void setDiscountTypeId(String discountTypeId) {
        this.discountTypeId = discountTypeId;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setSelectivePositions(ArrayList<String> selectivePositions) {
        this.selectivePositions = selectivePositions;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }
}
