package ru.denmehta.iikoService.iiko.request;

public class GetMenuRequest {

    public GetMenuRequest(String organizationId) {
        this.organizationId = organizationId;
    }

    private String organizationId;

    private int startRevision;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public int getStartRevision() {
        return startRevision;
    }

    public void setStartRevision(int startRevision) {
        this.startRevision = startRevision;
    }
}
