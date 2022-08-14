package ru.denmehta.iikoService.iiko;

import org.springframework.http.ResponseEntity;
import ru.denmehta.iikoService.iiko.classes.Order;
import ru.denmehta.iikoService.iiko.request.GetDeliveryByDateAndStatusRequest;
import ru.denmehta.iikoService.iiko.response.*;

import java.util.List;

public interface RestApiInterface {

    ResponseEntity<AccessTokenResponse> getAccessToken(String apiLogin);

    ResponseEntity<OrganizationsResponse> getOrganizations(String token);

    ResponseEntity<SendNotificationResponse> sendNotification(String token);

    ResponseEntity<GetMenuResponse> getMenu(String token, String organizationId);

    ResponseEntity<CustomerInfoResponse> getCustomer(String token, String organizationId, String phone);

    ResponseEntity<CreateDeliveryResponse> createDelivery(String token, String organizationId, String terminalGroupId, Order order);

    ResponseEntity<GetDeliveryByDateAndStatusResponse> getDeliveryByDateAndStatus(String token, List<String> organizationIds,
                                                                                  String deliveryDateFrom, String deliveryDateTo, List<String> statuses,
                                                                                  List<String> sourceKeys);

}
