package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;
import ru.denmehta.iikoService.repository.TerminalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {

    final TerminalRepository terminalRepository;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    public Optional<Terminal> getById(String id) {
        return terminalRepository.findById(id);
    }

    public List<Terminal> findByOrganization(Organization organization) {
        return terminalRepository.findByOrganization(organization);
    }

    public void save(Terminal terminal) {

    }

    public void delete(String id) {

    }

    public List<Terminal> findAll(){
        return terminalRepository.findAll();
    }
}
