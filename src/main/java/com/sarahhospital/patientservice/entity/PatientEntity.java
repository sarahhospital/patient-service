package com.sarahhospital.patientservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HumanNameEntity> humanNames;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderPersistent gender;

    @Column(name = "birthDate", length = 8)
    private String birthDate;
}
