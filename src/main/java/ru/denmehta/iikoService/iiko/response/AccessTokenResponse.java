package ru.denmehta.iikoService.iiko.response;



public class AccessTokenResponse extends IikoBaseResponse {

    private  String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
