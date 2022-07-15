package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.CustomerRepository;

import java.util.*;

@Service
public class CustomerService implements  UserDetailsService {

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

    public Customer getById(String id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return null;


    }

    public Optional<Customer> getByPhoneAndSite(String phone, Site site) {
        return customerRepository.findByPhoneAndSites(phone, site);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(String id) {

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


}
