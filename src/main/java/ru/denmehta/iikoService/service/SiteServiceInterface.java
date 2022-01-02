package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Site;

import java.util.List;

public interface SiteServiceInterface {

    Site findByToken(String token);

    Site findByDomain(String domain);

    List<Site> getActive();

    void save(Site site);

    void delete(String id);


}
