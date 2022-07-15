package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.repository.OrganizationRepository;

@Service
public class OrganizationService implements IBaseDbService<Organization, String> {

    final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public String getName() {
        return Organization.class.getName();
    }

    @Override
    public JpaRepository<Organization, String> getRepository() {
        return organizationRepository;
    }
}
