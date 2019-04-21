package com.sarahhospital.patientservice.model;

import lombok.Data;

@Data
public class HumanName {

    private NameUse use;

    private String text;

    private String family;

    private String patronymic;

    private String given;

    private Period period;
}
