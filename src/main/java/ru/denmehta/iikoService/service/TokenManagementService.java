package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.iiko.IikoRestApi;
import ru.denmehta.iikoService.models.Site;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TokenManagementService  {

    final SiteService siteService;
    public final IikoRestApi iikoRestApi;

    private final Map<Site, String> tokens;


    @Autowired
    public TokenManagementService(SiteService siteService, IikoRestApi iikoRestApi) {
        this.siteService = siteService;
        this.iikoRestApi = iikoRestApi;
        this.tokens = new HashMap<>();
        List<Site> sites = this.siteService.getActive();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Site site : sites) {
            executorService.submit(new GetSiteTokenRun(site, this));
        }
    }

    public String getToken(Site site) {
        return tokens.get(site);
    }

    public Map<Site, String> getTokens() {
        return tokens;
    }

    static class GetSiteTokenRun implements Runnable {

        private final Site site;
        private final TokenManagementService tokenManagementService;

        public GetSiteTokenRun(Site site, TokenManagementService tokenManagementService) {
            this.site = site;
            this.tokenManagementService = tokenManagementService;
        }

        @Override
        public void run() {
            try {
                String token = Objects.requireNonNull(tokenManagementService.iikoRestApi.getAccessToken(site.getApiLogin()).getBody()).getToken();
                tokenManagementService.tokens.put(site, token);
                Thread.sleep(1000 * 60 * 2);

            } catch (InterruptedException e) {
                System.out.println("Interrupt");
            }

        }


    }


}
