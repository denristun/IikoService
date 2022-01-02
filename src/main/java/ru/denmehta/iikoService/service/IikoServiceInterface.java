package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.*;

import java.util.List;

public interface IikoServiceInterface {

    public String getAccessToken(String apiLogin);

    public List<Product> getProducts(Site site);

    public List<Group> getGroups(Site site);

    public List<Organization> getOrganizations(Site site);

    public List<Size> getSizes(Site site);

    public Customer getCustomer(Site site, String phone);



}
