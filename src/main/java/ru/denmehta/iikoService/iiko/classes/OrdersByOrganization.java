package ru.denmehta.iikoService.iiko.classes;

import lombok.Data;

import java.util.List;

@Data
public class OrdersByOrganization {

    private String organizationId;

    private List<OrderInfo> orders;
}
