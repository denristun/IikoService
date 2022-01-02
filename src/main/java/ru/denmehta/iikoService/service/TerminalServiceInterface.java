package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;

import java.util.List;

public interface TerminalServiceInterface {
    Terminal getById(String id);

    List<Terminal> findByOrganization(Organization organization);

    void save(Terminal terminal);

    void delete(String id);


}
