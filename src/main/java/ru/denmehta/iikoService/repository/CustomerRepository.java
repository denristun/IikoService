package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Site;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByPhoneAndSites(String phone, Site site);
    Optional<Customer> findByPhone(String phone);

}
