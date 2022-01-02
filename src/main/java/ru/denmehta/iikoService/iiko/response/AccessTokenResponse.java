package ru.denmehta.iikoService.iiko.response;

import lombok.Getter;


public class AccessTokenResponse extends IikoResponse  {

    private  String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
