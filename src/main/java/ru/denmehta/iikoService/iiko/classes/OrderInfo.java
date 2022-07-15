package ru.denmehta.iikoService.iiko.classes;

public class OrderInfo {

    private String id;

    private String organizationId;

    private int timestamp;

    private String creationStatus;

    private ErrorInfo errorInfo;

    private DeliveryOrder order;

    public String getId() {
        return id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getCreationStatus() {
        return creationStatus;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public DeliveryOrder getOrder() {
        return order;
    }
}
