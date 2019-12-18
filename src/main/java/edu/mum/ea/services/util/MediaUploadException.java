package edu.mum.ea.services.util;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MediaUploadException extends RuntimeException {
    private String message;
    public MediaUploadException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
