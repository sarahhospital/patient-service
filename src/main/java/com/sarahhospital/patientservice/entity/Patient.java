package com.sarahhospital.patientservice.entity;

import com.sarahhospital.patientservice.model.GenderCode;
import com.sarahhospital.patientservice.model.HumanName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "active")
    private Boolean active;

    @OneToMany
    private List<HumanName> humanNames;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderCode gender;

    @Column(name = "birthDate", length = 8)
    private String birthDate;
}