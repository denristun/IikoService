package ru.denmehta.iikoService.iiko.enums;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DeliveryStatus {
    UNCONFIRMED("Unconfirmed"),
    WAIT_COOKING("WaitCooking"),
    READY_FOR_COOKING("ReadyForCooking"),
    COOKING_STARTED("CookingStarted"),
    COOKING_COMPLETED("CookingCompleted"),
    WAITING("Waiting"),
    ON_WAY("OnWay"),
    DELIVERED("Delivered"),
    CLOSED("Closed"),
    CANCELLED("Cancelled");

    private final String value;
    }
