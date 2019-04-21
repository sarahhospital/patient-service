package com.sarahhospital.patientservice.model;

import lombok.Data;

@Data
public class Identifier {

    private IdentifierUse use;

    private IdentifierType type;

    private String system;

    private String value;

    private Period period;
}
