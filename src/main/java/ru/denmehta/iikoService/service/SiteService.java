package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.SiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    final SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site getById(String siteId) {
        Optional<Site> optionalSite = siteRepository.findById(siteId);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        return null;
    }

    public Site findByToken(String token) {
        Optional<Site> optionalSite = siteRepository.findByToken(token);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        return null;
    }

    public Site findByDomain(String domain) {
        Optional<Site> optionalSite = siteRepository.findByDomain(domain);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        return null;
    }

    public List<Site> getActive() {
        Optional<List<Site>> optionalSites = siteRepository.getSitesByActive(true);
        if (optionalSites.isPresent()) {
            return optionalSites.get();
        }
        return null;
    }

    public List<Site> getAll() {
        return siteRepository.findAll();
    }


    public void save(Site site) {
        siteRepository.save(site);
    }

    public void deleteById(String siteId) {
        siteRepository.deleteById(siteId);
    }
}
