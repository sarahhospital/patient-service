package com.sarahhospital.patientservice.exceptions;

public class NoSuchPatientException extends RuntimeException {

    public NoSuchPatientException(String message) {
        super(message);
    }
}
