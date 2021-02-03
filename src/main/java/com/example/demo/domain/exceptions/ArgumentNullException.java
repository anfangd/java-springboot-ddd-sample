package com.example.demo.domain.exceptions;

public class ArgumentNullException extends IllegalArgumentException {

    public ArgumentNullException(String message) {
        super(message);
    }
}
