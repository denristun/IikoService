package ru.denmehta.iikoService.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class RestApiResponse {

    private int status;
    private String message;
    private Object data;
    private Date timestamp;

    public RestApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = Calendar.getInstance().getTime();
    }

    public RestApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp =  Calendar.getInstance().getTime();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
