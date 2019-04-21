package com.sarahhospital.dbservice.repository;

import com.sarahhospital.dbservice.entities.Patient;
import com.sarahhospital.dbservice.model.HumanName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findAll();

    Optional<Patient> findByName(HumanName humanName);
}
