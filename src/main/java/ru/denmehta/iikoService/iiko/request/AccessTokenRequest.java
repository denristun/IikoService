package ru.denmehta.iikoService.iiko.request;


public class AccessTokenRequest {
    private String apiLogin;

    public AccessTokenRequest(String apiLogin) {
        this.apiLogin = apiLogin;
    }

    public String getApiLogin() {
        return apiLogin;
    }

    public void setApiLogin(String apiLogin) {
        this.apiLogin = apiLogin;
    }
}
