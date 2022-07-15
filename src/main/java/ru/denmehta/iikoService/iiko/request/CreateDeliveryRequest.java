package ru.denmehta.iikoService.iiko.request;

import org.jetbrains.annotations.NotNull;
import ru.denmehta.iikoService.iiko.classes.CreateOrderSettings;
import ru.denmehta.iikoService.iiko.classes.Order;

public class CreateDeliveryRequest {

    public CreateDeliveryRequest(@NotNull String organizationId, @NotNull Order order) {
        this.organizationId = organizationId;
        this.order = order;
    }

    @NotNull
    private String organizationId;

    private String terminalGroupId;

    private CreateOrderSettings createOrderSettings;

    @NotNull
    private Order order;


    public void setOrganizationId(@NotNull String organizationId) {
        this.organizationId = organizationId;
    }

    public void setTerminalGroupId(String terminalGroupId) {
        this.terminalGroupId = terminalGroupId;
    }

    public void setCreateOrderSettings(CreateOrderSettings createOrderSettings) {
        this.createOrderSettings = createOrderSettings;
    }

    public void setOrder(@NotNull Order order) {
        this.order = order;
    }
}
