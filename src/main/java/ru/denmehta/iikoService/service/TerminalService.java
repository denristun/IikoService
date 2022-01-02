package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;
import ru.denmehta.iikoService.repository.TerminalRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TerminalService implements TerminalServiceInterface{

    final TerminalRepository terminalRepository;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Override
    public Terminal getById(String id) {

        Optional<Terminal> optionalTerminal = terminalRepository.findById(id);
        if (optionalTerminal.isPresent()) {
            return optionalTerminal.get();
        }
        return null;
    }

    @Override
    public List<Terminal> findByOrganization(Organization organization) {
        return terminalRepository.findByOrganization(organization);
    }

    @Override
    public void save(Terminal terminal) {

    }

    @Override
    public void delete(String id) {

    }
}
