package com.checkout.checkout.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ItemException extends RuntimeException{

    public ItemException(int id){

        super("The item with id: " + id + " don't have enough quantity.");
    }
}
