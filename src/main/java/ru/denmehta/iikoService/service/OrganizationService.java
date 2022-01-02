package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;
import ru.denmehta.iikoService.repository.OrganizationRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrganizationService implements OrganizationServiceInterface{

    final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization getById(String id) {

        Optional<Organization> optionalOrganization = organizationRepository.findById(id);
        if (optionalOrganization.isPresent()) {
            return optionalOrganization.get();
        }
        return null;
    }

    @Override
    public void save(Organization organization) {
        organizationRepository.save(organization);

    }


    @Override
    public void delete(String id) {

    }
}
