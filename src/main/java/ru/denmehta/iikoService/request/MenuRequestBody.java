package ru.denmehta.iikoService.request;

public class MenuRequestBody {

    private String token;

    private  String groupId;

    private  String productId;

    public String getToken() {
        return token;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getProductId() {
        return productId;
    }
}
