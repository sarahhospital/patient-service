package com.sarahhospital.patientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Identifier {

    private IdentifierCode use;

    private IdentifierType type;

    private String system;

    private String value;

    private Period period;
}
