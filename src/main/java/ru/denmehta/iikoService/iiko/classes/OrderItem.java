package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;
import ru.denmehta.iikoService.iiko.enums.ProductType;

import java.util.ArrayList;

public class OrderItem {

    @NotNull
    private String productId;

    private ArrayList<Modifier> modifiers;

    private double price;

    private String positionId;

    @NotNull
    private ProductType type;

    @NotNull
    private double amount;

    private String productSizeId;

    private String comment;

    private ComboInfo comboInformation;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setModifiers(ArrayList<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setProductSizeId(String productSizeId) {
        this.productSizeId = productSizeId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setComboInformation(ComboInfo comboInformation) {
        this.comboInformation = comboInformation;
    }
}
