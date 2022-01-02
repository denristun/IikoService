package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.SiteRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SiteService implements SiteServiceInterface {

    final SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }


    @Override
    public Site findByToken(String token) {
        Optional<Site> optionalSite = siteRepository.findByToken(token);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        return null;
    }

    @Override
    public Site findByDomain(String domain) {
        Optional<Site> optionalSite = siteRepository.findByDomain(domain);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        return null;
    }

    @Override
    public List<Site> getActive() {
        Optional<List<Site>> optionalSites = siteRepository.getSitesByActive(true);
        if (optionalSites.isPresent()) {
            return optionalSites.get();
        }
        return null;
    }

    @Override
    public void save(Site site) {

    }

    @Override
    public void delete(String id) {

    }
}
