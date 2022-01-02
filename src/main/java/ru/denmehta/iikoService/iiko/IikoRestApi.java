package ru.denmehta.iikoService.iiko;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.denmehta.iikoService.iiko.request.AccessTokenRequest;
import ru.denmehta.iikoService.iiko.request.CustomerInfoRequest;
import ru.denmehta.iikoService.iiko.request.GetMenuRequest;
import ru.denmehta.iikoService.iiko.request.OrganizationsRequest;
import ru.denmehta.iikoService.iiko.response.*;


@Slf4j
@Service
public class IikoRestApi implements IikoRestApiInterface {

    private final RestTemplate restTemplate;
    private final String IIKO_URL = "https://api-ru.iiko.services/api/1";

    public IikoRestApi() {
        this.restTemplate = new RestTemplateBuilder().build();
    }

    @Override
    public ResponseEntity<AccessTokenResponse> getAccessToken(String apiLogin) {
        AccessTokenRequest request = new AccessTokenRequest(apiLogin);
        return restTemplate.postForEntity(IIKO_URL + "/access_token", request, AccessTokenResponse.class);
    }

    @Override
    public ResponseEntity<OrganizationsResponse> getOrganizations(String token){
        OrganizationsRequest request = new OrganizationsRequest();
        request.setReturnAdditionalInfo(true);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<OrganizationsRequest> entity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/organizations",  entity, OrganizationsResponse.class);
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
        HttpEntity<GetMenuRequest> entity = new HttpEntity<GetMenuRequest>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/nomenclature",  entity, GetMenuResponse.class);

    }

    @Override
    public ResponseEntity<CustomerInfoResponse> getCustomer(String token, String phone) {
        CustomerInfoRequest request = new CustomerInfoRequest(phone);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<CustomerInfoRequest> entity = new HttpEntity<CustomerInfoRequest>(request, headers);
        return restTemplate.postForEntity(IIKO_URL + "/get_customer",  entity, CustomerInfoResponse.class);
    }


}
