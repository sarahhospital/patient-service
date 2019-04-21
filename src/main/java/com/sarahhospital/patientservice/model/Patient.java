package com.sarahhospital.patientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private List<Identifier> identifier;

    private Boolean active;

    private List<HumanName> humanNames;

    private GenderCode gender;

    private String birthDate;
}
