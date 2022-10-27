package br.com.elebasi.who_owes_me.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotFoundException extends Exception{
    public int code;
    public String message;
}
