package ru.denmehta.iikoService.iiko.request;

public class CustomerInfoRequest {

    public CustomerInfoRequest(String organizationId, String phone) {
        this.type = "phone";
        this.phone = phone;
        this.organizationId = organizationId;
    }

    private String type;

    private String phone;

    private String cardTrack;

    private String cardNumber;

    private String organizationId;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardTrack() {
        return cardTrack;
    }

    public void setCardTrack(String cardTrack) {
        this.cardTrack = cardTrack;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
