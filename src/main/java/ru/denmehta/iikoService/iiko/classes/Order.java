package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;
import ru.denmehta.iikoService.iiko.enums.OrderServiceType;
import ru.denmehta.iikoService.models.Customer;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private String id;

    private Date completeBefore;

    @NotNull
    private String phone;

    private String orderTypeId;

    private OrderServiceType orderServiceType;

    private DeliveryPoint deliveryPoint;

    private String comment;

    @NotNull
    private Customer customer;

    private GuestInfo guests;

    private String marketingSourceId;

    private String operatorId;

    @NotNull
    private ArrayList<OrderItem> items;

    private ArrayList<Combo> combos;

    private ArrayList<Payment> payments;

    private ArrayList<Tip> tips;

    private String sourceKey;

    private DiscountsInfo discountsInfo;

    private IikoCard5Info iikoCard5Info;

    public void setId(String id) {
        this.id = id;
    }

    public void setCompleteBefore(Date completeBefore) {
        this.completeBefore = completeBefore;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public void setOrderServiceType(OrderServiceType orderServiceType) {
        this.orderServiceType = orderServiceType;
    }

    public void setDeliveryPoint(DeliveryPoint deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setGuests(GuestInfo guests) {
        this.guests = guests;
    }

    public void setMarketingSourceId(String marketingSourceId) {
        this.marketingSourceId = marketingSourceId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public void setCombos(ArrayList<Combo> combos) {
        this.combos = combos;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public void setTips(ArrayList<Tip> tips) {
        this.tips = tips;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public void setDiscountsInfo(DiscountsInfo discountsInfo) {
        this.discountsInfo = discountsInfo;
    }

    public void setIikoCard5Info(IikoCard5Info iikoCard5Info) {
        this.iikoCard5Info = iikoCard5Info;
    }
}
