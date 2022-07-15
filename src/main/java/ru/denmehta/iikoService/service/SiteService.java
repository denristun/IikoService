package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.SiteRepository;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.List;

@Service
public class SiteService implements IBaseDbService<Site, String> {

    final SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site findByToken(String token) {
       return siteRepository.findByToken(token).orElseThrow(() -> new RestApiException(HttpStatus.NOT_FOUND, "site not found"));

    }

    public Site findByDomain(String domain) {
        return siteRepository.findByDomain(domain).orElseThrow(() -> new RestApiException(HttpStatus.UNAUTHORIZED, "not allowed from domain " + domain));

    }

    public List<Site> getActive() {
        return siteRepository.getSitesByActive(true);
    }

    @Override
    public String getName() {
        return Site.class.getName();
    }

    @Override
    public JpaRepository<Site, String> getRepository() {
        return siteRepository;
    }
}
