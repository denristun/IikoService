package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.iiko.IikoRestApi;
import ru.denmehta.iikoService.iiko.classes.OrdersByOrganization;
import ru.denmehta.iikoService.iiko.request.GetDeliveryByDateAndStatusRequest;
import ru.denmehta.iikoService.iiko.response.CustomerInfoResponse;
import ru.denmehta.iikoService.iiko.response.GetDeliveryByDateAndStatusResponse;
import ru.denmehta.iikoService.iiko.response.GetMenuResponse;
import ru.denmehta.iikoService.iiko.response.OrganizationsResponse;
import ru.denmehta.iikoService.models.*;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.*;

@Service
public class IikoService  {

    private final IikoRestApi iikoRestApi;
    private final TokenManagementService tokenManagementService;


    @Autowired
    public IikoService(IikoRestApi iikoRestApi, TokenManagementService tokenManagementService) {
        this.iikoRestApi = iikoRestApi;
        this.tokenManagementService = tokenManagementService;
    }

    public String getAccessToken(String apiLogin) {
        return iikoRestApi.getAccessToken(apiLogin).getBody().getToken();
    }

    public List<Product> getProducts(Site site) {
        String token = this.tokenManagementService.getIikoToken(site);
        ResponseEntity<GetMenuResponse> response = iikoRestApi.getMenu(token,  site.getOrganizations().stream().findFirst().get().getId());
        return response.getBody().getProducts();
    }

    public List<Group> getGroups(Site site) {
        String token = this.tokenManagementService.getIikoToken(site);
        ResponseEntity<GetMenuResponse> response = iikoRestApi.getMenu(token,  site.getOrganizations().stream().findFirst().get().getId());
        return Objects.requireNonNull(response.getBody()).getGroups();
    }

    public List<Organization> getOrganizations(Site site) {
        String token = this.tokenManagementService.getIikoToken(site);
        ResponseEntity<OrganizationsResponse> response = iikoRestApi.getOrganizations(token);
        return Objects.requireNonNull(response.getBody()).getOrganizations();
    }

    public List<Size> getSizes(Site site) {
        String token = tokenManagementService.getIikoToken(site);
        ResponseEntity<GetMenuResponse> response = iikoRestApi.getMenu(token,  site.getOrganizations().stream().findFirst().get().getId());
        return Objects.requireNonNull(response.getBody()).getSizes();
    }

    public Customer getCustomer(Site site, String phone) {
        String token = tokenManagementService.getIikoToken(site);
        String organizationId = site.getOrganizations().stream().findFirst().get().getId();

        CustomerInfoResponse customerInfo = iikoRestApi.getCustomer(token, organizationId, phone).getBody();
        Customer customer = new Customer();
        HashSet<Site> sites = new HashSet<>();
        customer.setName(customerInfo.getName());
        customer.setMiddleName(customerInfo.getMiddleName());
        customer.setSurname(customerInfo.getSurname());
        customer.setSex(customerInfo.getSex());
        customer.setEmail(customerInfo.getEmail());
        customer.setBonus(customerInfo.getBonus());
        sites.add(site);
        customer.setPhone(phone);
        customer.setSites(sites);
        return  customer;
    }


    public List<OrdersByOrganization> getDeliveryByDateAndStatus(Site site, GetDeliveryByDateAndStatusRequest request){
        String token = tokenManagementService.getIikoToken(site);
        String organizationId = site.getOrganizations().stream().findFirst().get().getId();

        GetDeliveryByDateAndStatusResponse response = iikoRestApi.getDeliveryByDateAndStatus(token,
                Collections.singletonList(organizationId),
                request.getDeliveryDateFrom(),
                request.getDeliveryDateTo(),
                null,
                null).getBody();

        if((response != null ? response.getErrorDescription() : null) != null)
            throw new RestApiException(HttpStatus.BAD_REQUEST, response.getErrorDescription());


        return response.getOrdersByOrganizations();


    }
}
