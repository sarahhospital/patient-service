package com.sarahhospital.patientservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Period {

    @Column(name = "start_date_time")
    private Long start;

    @Column(name = "end_date_time")
    private Long end;
}
