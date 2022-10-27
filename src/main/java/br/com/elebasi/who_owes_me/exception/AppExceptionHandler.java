package br.com.elebasi.who_owes_me.exception;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({ValueInstantiationException.class, MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleExceptionPersonalized(){
        return new ResponseEntity<>(new ApiErrorResponse(4001, "Informe os campos corretamente.", HttpStatus.BAD_REQUEST), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ApiErrorResponse handleExceptionNotFound(NotFoundException ex){
        return new ApiErrorResponse(ex.getCode(), ex.getMessage(),  HttpStatus.NOT_FOUND);
    }



}
