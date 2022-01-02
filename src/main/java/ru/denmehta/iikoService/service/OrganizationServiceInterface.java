package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;

public interface OrganizationServiceInterface {

    Organization getById(String id);

    void save(Organization organization);

    void delete(String id);


}
