package com.example.notes.exception;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(Long id){
        super("Note with id:" + id + " not found");
    }
}
