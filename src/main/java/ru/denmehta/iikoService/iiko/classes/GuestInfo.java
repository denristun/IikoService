package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;

public class GuestInfo {

    @NotNull
    private int count;

    @NotNull
    private boolean splitBetweenPersons;

    public void setCount(int count) {
        this.count = count;
    }

    public void setSplitBetweenPersons(boolean splitBetweenPersons) {
        this.splitBetweenPersons = splitBetweenPersons;
    }
}
