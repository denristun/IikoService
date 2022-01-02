package ru.denmehta.iikoService.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Site;

import java.util.Date;
import java.util.List;

public interface CustomerServiceInterface {
    Customer getById(String id);

    Customer getByPhoneAndSite(String phone, Site site);

    void save(Customer customer);

    void delete(String id);


    UserDetails loadUserByPhoneAndDomain(String phone, Site site);





}
