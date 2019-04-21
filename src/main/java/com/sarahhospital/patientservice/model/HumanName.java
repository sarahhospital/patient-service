package com.sarahhospital.patientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HumanName {

    public HumanName(String given, String patronymic, String family) {
        this.family = family;
        this.patronymic = patronymic;
        this.given = given;
    }

    private NameCode use;

    private String text;

    private String family;

    private String patronymic;

    private String given;

    private Period period;
}
