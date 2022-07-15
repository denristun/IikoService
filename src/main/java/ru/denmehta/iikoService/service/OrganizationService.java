package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;
import ru.denmehta.iikoService.repository.OrganizationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization getById(String id) {

        Optional<Organization> optionalOrganization = organizationRepository.findById(id);
        if (optionalOrganization.isPresent()) {
            return optionalOrganization.get();
        }
        return null;
    }

    public void save(Organization organization) {
        organizationRepository.save(organization);

    }


    public void delete(String id) {

    }
}
