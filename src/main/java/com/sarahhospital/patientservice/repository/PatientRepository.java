package com.sarahhospital.patientservice.repository;

import com.sarahhospital.patientservice.entities.Patient;
import com.sarahhospital.patientservice.model.HumanName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findAll();

    Optional<Patient> findByName(HumanName humanName);
}
