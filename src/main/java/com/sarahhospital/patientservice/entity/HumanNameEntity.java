package com.sarahhospital.patientservice.entity;

import com.sarahhospital.patientservice.model.NameCode;
import com.sarahhospital.patientservice.model.Period;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "human_name")
public class HumanNameEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "use")
    private NameCode use;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Enumerated(EnumType.STRING)
    @Column(name = "period")
    private Period period;
}


