package com.sarahhospital.patientservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Patient {

    private List<Identifier> identifiers;

    private Boolean active;

    private List<HumanName> humanNames;

    private Gender gender;

    private String birthDate;
}
