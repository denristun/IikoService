package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Site;

import java.util.List;

public interface GroupServiceInterface {
    Group getById(String id);

    void save(Group group);

    void delete(String id);

    List<Group> getAll();

    List<Group> getAllSiteDisplayedAndSite(Site site);
}
