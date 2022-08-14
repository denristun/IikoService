package ru.denmehta.iikoService.iiko.response;

import lombok.Data;
import ru.denmehta.iikoService.iiko.classes.OrdersByOrganization;

import java.util.List;

@Data
public class GetDeliveryByDateAndStatusResponse extends IikoBaseResponse {

    private String maxRevision;

    private List<OrdersByOrganization> ordersByOrganizations;

}
