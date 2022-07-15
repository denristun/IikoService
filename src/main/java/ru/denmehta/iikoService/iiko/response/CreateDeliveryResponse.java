package ru.denmehta.iikoService.iiko.response;

import ru.denmehta.iikoService.iiko.classes.OrderInfo;

public class CreateDeliveryResponse extends IikoBaseResponse {

    private OrderInfo orderInfo;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }
}
