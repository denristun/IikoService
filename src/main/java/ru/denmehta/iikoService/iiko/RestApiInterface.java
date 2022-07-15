package ru.denmehta.iikoService.iiko;

import org.springframework.http.ResponseEntity;
import ru.denmehta.iikoService.iiko.classes.Order;
import ru.denmehta.iikoService.iiko.response.*;

public interface RestApiInterface {

    public ResponseEntity<AccessTokenResponse> getAccessToken(String apiLogin);

    public ResponseEntity<OrganizationsResponse> getOrganizations(String token);

    public ResponseEntity<SendNotificationResponse> sendNotification(String token);

    public ResponseEntity<GetMenuResponse> getMenu(String token, String organizationId);

    public ResponseEntity<CustomerInfoResponse> getCustomer(String token, String organizationId, String phone);

    public ResponseEntity<CreateDeliveryResponse> createDelivery(String token, String organizationId, String terminalGroupId, Order order);
}
