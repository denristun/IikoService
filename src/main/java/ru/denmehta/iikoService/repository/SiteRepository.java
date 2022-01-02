package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Site;

import java.util.List;
import java.util.Optional;

public interface SiteRepository extends JpaRepository<Site, String> {
    Optional<Site> findByToken(String token);
    Optional<Site> findByDomain(String domain);
    Optional<List<Site>> getSitesByActive(boolean active);

}
