package ru.denmehta.iikoService.request;

import javax.persistence.Column;

public class SiteRequestBody {

    private String siteId;

    private String domain;

    private String token;

    private String apiLogin;

    private boolean active;

    public String getSiteId() {
        return siteId;
    }

    public String getDomain() {
        return domain;
    }

    public String getToken() {
        return token;
    }

    public String getApiLogin() {
        return apiLogin;
    }

    public boolean isActive() {
        return active;
    }
}
