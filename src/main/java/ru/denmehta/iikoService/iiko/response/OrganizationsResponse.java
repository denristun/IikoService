package ru.denmehta.iikoService.iiko.response;

import lombok.Getter;
import ru.denmehta.iikoService.models.Organization;

import java.util.List;
@Getter
public class OrganizationsResponse extends IikoResponse {

    List<Organization> organizations;

    public List<Organization> getOrganizations() {
        return organizations;
    }
}

