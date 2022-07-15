package ru.denmehta.iikoService.iiko;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.denmehta.iikoService.iiko.classes.Order;
import ru.denmehta.iikoService.iiko.handler.IikoResponseErrorHandler;
import ru.denmehta.iikoService.iiko.request.*;
import ru.denmehta.iikoService.iiko.response.*;

@Service
public class IikoRestApi implements RestApiInterface {

    private final RestTemplate restTemplate;
    private final String IIKO_URL = "https://api-ru.iiko.services/api/1";

    public IikoRestApi() {
        this.restTemplate = new RestTemplateBuilder().errorHandler(new IikoResponseErrorHandler()).build();
    }

    @Override
    public ResponseEntity<AccessTokenResponse> getAccessToken(String apiLogin) {
        AccessTokenRequest request = new AccessTokenRequest(apiLogin);
        return restTemplate.postForEntity(IIKO_URL + "/access_token", request, AccessTokenResponse.class);
    }

    @Override
    public ResponseEntity<OrganizationsResponse> getOrganizations(String token) {
        OrganizationsRequest request = new OrganizationsRequest();
        request.setReturnAdditionalInfo(true);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<OrganizationsRequest> entity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/organizations", entity, OrganizationsResponse.class);
    }

    @Override
    public ResponseEntity<SendNotificationResponse> sendNotification(String token) {
        return null;
    }

    @Override
    public ResponseEntity<GetMenuResponse> getMenu(String token, String organizationId) {
        GetMenuRequest request = new GetMenuRequest(organizationId);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<GetMenuRequest> entity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/nomenclature", entity, GetMenuResponse.class);

    }

    @Override
    public ResponseEntity<CustomerInfoResponse> getCustomer(String token, String organizationId, String phone) {
        CustomerInfoRequest request = new CustomerInfoRequest(organizationId, phone);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<CustomerInfoRequest> httpEntity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/loyalty/iiko/get_customer", httpEntity, CustomerInfoResponse.class);
    }

    @Override
    public ResponseEntity<CreateDeliveryResponse> createDelivery(String token, String organizationId,
                                                                 String terminalGroupId, Order order) {

        CreateDeliveryRequest request = new CreateDeliveryRequest(organizationId, order);
        request.setTerminalGroupId(terminalGroupId);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<CreateDeliveryRequest> httpEntity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/deliveries/create", httpEntity, CreateDeliveryResponse.class);

    }


}
