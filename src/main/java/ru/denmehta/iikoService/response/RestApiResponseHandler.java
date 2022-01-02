package ru.denmehta.iikoService.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.Objects;

@ControllerAdvice
public class RestApiResponseHandler implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(value = {RestApiException.class})
    public ResponseEntity<Object> handleException(RestApiException exception) {
        HttpStatus status = exception.getStatusCode();
        return new ResponseEntity<>(exception, status);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof  RestApiException) {
            return new RestApiResponse(((RestApiException) body).getRawStatusCode(), ((RestApiException) body).getStatusText());
        }


        if(body instanceof LinkedHashMap){
            return new RestApiResponse((int) ((LinkedHashMap<String, Object>) body).get("status"),
                    (String)((LinkedHashMap<String, Object>) body).get("error"));
        }

        return new RestApiResponse(HttpStatus.OK.value(), "OK", body);
    }
}
