package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
    List<Group> findByIsSiteDisplayAndSite(boolean isSiteDisplay, Site site);
}