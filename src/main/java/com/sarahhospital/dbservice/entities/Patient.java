package com.sarahhospital.dbservice.entities;

import com.sarahhospital.dbservice.model.Address;
import com.sarahhospital.dbservice.model.GenderCode;
import com.sarahhospital.dbservice.model.HumanName;
import com.sarahhospital.dbservice.model.Identifier;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "passport")
    private Identifier identifier;

    @Column(name = "status")
    private boolean active;

    @Embedded
    @Column(name = "name")
    private HumanName name;

    @Column(name = "gender")
    private GenderCode gender;

    @Column(name = "birthDate")
    private Long birthDate;

    @Embedded
    @Column(name = "address")
    private Address address;
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
}
