package ru.denmehta.iikoService.iiko.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.denmehta.iikoService.iiko.enums.DeliveryStatus;

import java.util.List;

@Data
@Builder(setterPrefix = "set")
public class GetDeliveryByDateAndStatusRequest {

    private List<String> organizationIds;

    private String deliveryDateFrom;

    private String deliveryDateTo;

    private List<String> statuses;

    private List<String> sourceKeys;


}
