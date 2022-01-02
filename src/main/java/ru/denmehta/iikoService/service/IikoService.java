package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.iiko.IikoRestApi;
import ru.denmehta.iikoService.iiko.response.AccessTokenResponse;
import ru.denmehta.iikoService.iiko.response.CustomerInfoResponse;
import ru.denmehta.iikoService.iiko.response.GetMenuResponse;
import ru.denmehta.iikoService.iiko.response.OrganizationsResponse;
import ru.denmehta.iikoService.models.*;

import java.util.List;

@Service
public class IikoService implements IikoServiceInterface {

    private final IikoRestApi iikoRestApi;
    private final TokenManagementService tokenManagementService;


    @Autowired
    public IikoService(IikoRestApi iikoRestApi, TokenManagementService tokenManagementService) {
        this.iikoRestApi = iikoRestApi;
        this.tokenManagementService = tokenManagementService;
    }

    @Override
    public String getAccessToken(String apiLogin) {
        AccessTokenResponse response = iikoRestApi.getAccessToken(apiLogin).getBody();
        return response.getToken();
    }

    @Override
    public List<Product> getProducts(Site site) {

        String token = this.tokenManagementService.getToken(site);
        ResponseEntity<GetMenuResponse> response = iikoRestApi.getMenu(token,  site.getOrganizations().stream().findFirst().get().getId());
        return response.getBody().getProducts();

    }

    @Override
    public List<Group> getGroups(Site site) {

        String token = this.tokenManagementService.getToken(site);
        ResponseEntity<GetMenuResponse> response = iikoRestApi.getMenu(token,  site.getOrganizations().stream().findFirst().get().getId());
        return response.getBody().getGroups();
    }

    @Override
    public List<Organization> getOrganizations(Site site) {
        String token = this.tokenManagementService.getToken(site);
        ResponseEntity<OrganizationsResponse> response = iikoRestApi.getOrganizations(token);
        return response.getBody().getOrganizations();
    }

    @Override
    public List<Size> getSizes(Site site) {

        String token = this.tokenManagementService.getToken(site);
        ResponseEntity<GetMenuResponse> response = iikoRestApi.getMenu(token,  site.getOrganizations().stream().findFirst().get().getId());
        return response.getBody().getSizes();
    }

    @Override
    public Customer getCustomer(Site site, String phone) {
        String token = this.tokenManagementService.getToken(site);
//TODO доделать
        ResponseEntity<CustomerInfoResponse> response = iikoRestApi.getCustomer(token, phone);
        Customer customer = new Customer();
        customer.setPhone(response.getBody().getPhone());
        customer.setName(response.getBody().getName());
        customer.setSex(response.getBody().getSex());


        return  customer;
    }
}
