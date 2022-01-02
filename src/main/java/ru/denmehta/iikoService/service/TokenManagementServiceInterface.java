package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Site;

import java.util.Map;

public interface TokenManagementServiceInterface {

    public String getToken(Site site);

    public Map<String, String> getTokens();


}
