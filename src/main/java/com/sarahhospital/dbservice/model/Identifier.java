package com.sarahhospital.dbservice.model;

import lombok.Data;

@Data
public class Identifier {

    private static final String SYSTEM = "urn:uuid:bdc6dae0-c255-45c0-b037-8b2a4b91c9bb";

    private String value;
}
