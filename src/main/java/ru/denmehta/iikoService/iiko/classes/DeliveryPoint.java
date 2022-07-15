package ru.denmehta.iikoService.iiko.classes;


public class DeliveryPoint {

    private Coordinates coordinates;

    private Address address;

    private String externalCartographyId;

    private String comment;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setExternalCartographyId(String externalCartographyId) {
        this.externalCartographyId = externalCartographyId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
