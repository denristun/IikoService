package ru.denmehta.iikoService.iiko.response;

import java.util.UUID;

public class IikoResponse {

    private UUID correlationId;

    private String error;

    private String errorDescription;

    public UUID getCorrelationId() {
        return correlationId;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
