package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.iiko.IikoRestApi;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TokenManagementService  {

    final SiteService siteService;
    public final IikoRestApi iikoRestApi;

    private final Map<String, String> tokens;


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

    public String getIikoToken(Site site) {
        return Optional.ofNullable(tokens.get(site.getApiLogin())).orElseThrow(() -> new RestApiException(HttpStatus.NOT_FOUND, "no iiko token"));
    }

    public Map<String, String> getTokens() {
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
                tokenManagementService.tokens.put(site.getApiLogin(), token);
                Thread.sleep(1000 * 60 * 2);

            } catch (InterruptedException e) {
                System.out.println("Interrupt");
            }

        }


    }


}
