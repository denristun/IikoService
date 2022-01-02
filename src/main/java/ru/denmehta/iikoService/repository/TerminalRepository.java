package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.models.Terminal;

import java.util.List;
import java.util.Optional;

public interface TerminalRepository extends JpaRepository<Terminal, String> {

    List<Terminal> findByOrganization(Organization organization);

}
