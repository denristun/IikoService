package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;
import ru.denmehta.iikoService.repository.TerminalRepository;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.List;

@Service
public class TerminalService implements IBaseDbService<Terminal, String> {

    final TerminalRepository terminalRepository;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }


    public List<Terminal> findByOrganization(Organization organization) {
        return terminalRepository.findByOrganization(organization);
    }

    @Override
    public String getName() {
        return Terminal.class.getName();
    }

    @Override
    public JpaRepository<Terminal, String> getRepository() {
        return terminalRepository;
    }
}
