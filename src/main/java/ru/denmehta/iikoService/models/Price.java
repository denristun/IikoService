package ru.denmehta.iikoService.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "price")
public class Price extends  BaseEntity{

    @Id
    private String id;

    @Column
    private double currentPrice;

    @Column
    private boolean isIncludedInMenu;

    @Column
    private double nextPrice;

    @Column
    private boolean nextIncludedInMenu;

    @Column
    private String nextDatePrice;


    @OneToMany(mappedBy="price", targetEntity = SizePrice.class)
    private Set<SizePrice> sizes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public boolean isIncludedInMenu() {
        return isIncludedInMenu;
    }

    public void setIncludedInMenu(boolean includedInMenu) {
        isIncludedInMenu = includedInMenu;
    }

    public double getNextPrice() {
        return nextPrice;
    }

    public void setNextPrice(double nextPrice) {
        this.nextPrice = nextPrice;
    }

    public boolean isNextIncludedInMenu() {
        return nextIncludedInMenu;
    }

    public void setNextIncludedInMenu(boolean nextIncludedInMenu) {
        this.nextIncludedInMenu = nextIncludedInMenu;
    }

    public String getNextDatePrice() {
        return nextDatePrice;
    }

    public void setNextDatePrice(String nextDatePrice) {
        this.nextDatePrice = nextDatePrice;
    }
}
