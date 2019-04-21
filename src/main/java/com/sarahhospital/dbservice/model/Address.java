package com.sarahhospital.dbservice.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    private AddressCode use;

    private String text;

    private String city;

    private String state;

    private String country;
}
