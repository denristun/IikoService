package ru.denmehta.iikoService.iiko.response;

import ru.denmehta.iikoService.models.Organization;

import java.util.List;
public class OrganizationsResponse extends IikoBaseResponse {

    List<Organization> organizations;

    public List<Organization> getOrganizations() {
        return organizations;
    }
}

