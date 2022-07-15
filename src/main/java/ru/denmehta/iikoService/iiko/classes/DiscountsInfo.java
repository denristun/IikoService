package ru.denmehta.iikoService.iiko.classes;

import java.util.ArrayList;

public class DiscountsInfo {

    private Card card;

    private ArrayList<Discount> discounts;

    public void setCard(Card card) {
        this.card = card;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}
