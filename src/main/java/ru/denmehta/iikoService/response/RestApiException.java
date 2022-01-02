package ru.denmehta.iikoService.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

public class RestApiException extends HttpStatusCodeException {


    public RestApiException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
