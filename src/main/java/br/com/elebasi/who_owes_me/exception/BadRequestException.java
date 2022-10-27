package br.com.elebasi.who_owes_me.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;


public class BadRequestException extends Exception{
    private int code;
    private String message;

    public BadRequestException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
