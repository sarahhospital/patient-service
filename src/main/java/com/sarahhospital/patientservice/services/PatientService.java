package com.sarahhospital.patientservice.services;

import com.sarahhospital.patientservice.entity.GenderPersistent;
import com.sarahhospital.patientservice.entity.HumanNameEntity;
import com.sarahhospital.patientservice.entity.PatientEntity;
import com.sarahhospital.patientservice.model.*;
import com.sarahhospital.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        List<PatientEntity> patientList = patientRepository.findAll();
        return patientList.stream().map(patientEntity -> {
            Patient patient = new Patient();
            Identifier id = new Identifier();
            id.setValue(patientEntity.getId().toString());
            id.setType(IdentifierType.COCOS_PATIENT_ID);
            id.setSystem(Uris.COCOS_PATIENT_ID);
            patient.setIdentifiers(Collections.singletonList(id));
            patient.setHumanNames(patientEntity.getHumanNames().stream().map(humanNameEntity -> {
                HumanName humanName = new HumanName();
                humanName.setFamily(humanNameEntity.getLastName());
                humanName.setGiven(humanNameEntity.getFirstName());
                humanName.setPatronymic(humanNameEntity.getMiddleName());
                return humanName;
            }).collect(Collectors.toList()));
            patient.setActive(patientEntity.getActive());
            patient.setGender(Gender.valueOf(patientEntity.getGender().name()));
            patient.setBirthDate(patientEntity.getBirthDate());
            return patient;
        }).collect(Collectors.toList());
    }

    public Long createPatient(Patient patient) {
        HumanName humanName = patient.getHumanNames().get(0);
        HumanNameEntity humanNameEntity = new HumanNameEntity();
        humanNameEntity.setLastName(humanName.getFamily());
        humanNameEntity.setFirstName(humanName.getGiven());
        humanNameEntity.setMiddleName(humanName.getPatronymic());
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setHumanNames(Collections.singletonList(humanNameEntity));
        humanNameEntity.setPatient(patientEntity);
        patientEntity.setActive(true);
        patientEntity.setBirthDate(patient.getBirthDate());
        patientEntity.setGender(GenderPersistent.valueOf(patient.getGender().name()));
        return patientRepository.save(patientEntity).getId();
    }
}
