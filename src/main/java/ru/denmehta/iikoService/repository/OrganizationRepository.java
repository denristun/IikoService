package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Terminal;

public interface OrganizationRepository extends JpaRepository<Organization, String> {


}
