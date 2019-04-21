package com.sarahhospital.dbservice.exceptions;

public class NoSuchPatientException extends RuntimeException {

    public NoSuchPatientException(String message) {
        super(message);
    }
}
