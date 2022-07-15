package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.CustomerRepository;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.*;

@Service
public class CustomerService implements  UserDetailsService, IBaseDbService<Customer, String> {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findByPhone(phone);
        if (optionalCustomer.isPresent()) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("all"));
            return new User(phone, "", authorities);
        }
//        log.info("user with phone: {} not found", phone);
        throw new UsernameNotFoundException("User not found");
    }

    public Customer getByPhoneAndSite(String phone, Site site) {
        return customerRepository.findByPhoneAndSites(phone, site).orElseThrow(() -> new RestApiException(HttpStatus.NOT_FOUND, "customer not found"));
    }

    public boolean isCustomerExist(String phone, Site site){
        return Optional.ofNullable(getByPhoneAndSite(phone, site)).isPresent();
    }

    public UserDetails loadUserByPhoneAndDomain(String phone, Site site) {
        Optional<Customer> optionalCustomer = customerRepository.findByPhoneAndSites(phone, site);
        if (optionalCustomer.isPresent()) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("all"));
            return new User(phone, "", authorities);
        }
        throw new UsernameNotFoundException("Customer not found");
    }

    @Override
    public String getName() {
        return Customer.class.getName();
    }

    @Override
    public JpaRepository<Customer, String> getRepository() {
        return customerRepository;
    }
}
