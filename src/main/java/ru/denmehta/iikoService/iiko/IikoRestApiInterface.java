package ru.denmehta.iikoService.iiko;

import org.springframework.http.ResponseEntity;
import ru.denmehta.iikoService.iiko.response.*;

public interface IikoRestApiInterface {

    public  ResponseEntity<AccessTokenResponse> getAccessToken(String apiLogin);

    public ResponseEntity<OrganizationsResponse> getOrganizations(String token);

    public ResponseEntity<SendNotificationResponse> sendNotification(String token);

    public ResponseEntity<GetMenuResponse> getMenu(String token, String organizationId);

    public ResponseEntity<CustomerInfoResponse> getCustomer(String token, String phone);
}
