package com.sarahhospital.dbservice.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class HumanName {

    public HumanName(String given, String patronymic, String family) {
        this.family = family;
        this.patronymic = patronymic;
        this.given = given;
    }

    private NameCode code;

    private String text;

    private String family;

    private String patronymic;

    private String given;

    private String prefix;

    private String suffix;

    private Period period;
}
