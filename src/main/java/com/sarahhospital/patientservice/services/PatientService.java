package com.sarahhospital.patientservice.services;

import com.sarahhospital.patientservice.entity.HumanNameEntity;
import com.sarahhospital.patientservice.entity.Patient;
import com.sarahhospital.patientservice.exceptions.NoSuchPatientException;
import com.sarahhospital.patientservice.model.HumanName;
import com.sarahhospital.patientservice.repository.HumanNamesRepository;
import com.sarahhospital.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    private HumanNamesRepository humanNamesRepository;

    public PatientService(PatientRepository patientRepository, HumanNamesRepository humanNamesRepository) {
        this.patientRepository = patientRepository;
        this.humanNamesRepository = humanNamesRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<Patient> findPatientByName(HumanName humanName) {
        List<HumanNameEntity> names = humanNamesRepository
                .findByFirstNameAndMiddleNameAndLastName(humanName.getGiven(), humanName.getPatronymic(), humanName.getFamily());
        return names.stream()
                .map(HumanNameEntity::getPatient)
                .distinct()
                .collect(Collectors.toList());
    }

    public Patient findPatientById(Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new NoSuchPatientException("There is no patient with such id"));
    }

    public Long createPatient(Patient patient) {
        return patientRepository.save(patient).getId();
    }

    public Long updatePatient(Patient patient) {
        return patientRepository.save(patient).getId();
    }

    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }
}
