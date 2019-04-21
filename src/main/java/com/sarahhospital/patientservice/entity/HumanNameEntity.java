package com.sarahhospital.patientservice.entity;

import com.sarahhospital.patientservice.model.NameCode;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "human_name")
public class HumanNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    @Column(name = "use")
    private NameCode use;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Embedded
    @Column(name = "period")
    private Period period;
}


