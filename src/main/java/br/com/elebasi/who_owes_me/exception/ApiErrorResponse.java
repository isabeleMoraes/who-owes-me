package br.com.elebasi.who_owes_me.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private int code;
    private String message;
    private HttpStatus status;
}
