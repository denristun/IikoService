package ru.denmehta.iikoService.iiko.request;

import java.util.List;

public class OrganizationsRequest {

    List<String> organizationIds;

    boolean returnAdditionalInfo;

    boolean includeDisabled;

    public List<String> getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(List<String> organizationIds) {
        this.organizationIds = organizationIds;
    }

    public boolean isReturnAdditionalInfo() {
        return returnAdditionalInfo;
    }

    public void setReturnAdditionalInfo(boolean returnAdditionalInfo) {
        this.returnAdditionalInfo = returnAdditionalInfo;
    }

    public boolean isIncludeDisabled() {
        return includeDisabled;
    }

    public void setIncludeDisabled(boolean includeDisabled) {
        this.includeDisabled = includeDisabled;
    }
}
