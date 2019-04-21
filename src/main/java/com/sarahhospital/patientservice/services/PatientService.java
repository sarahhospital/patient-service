package com.sarahhospital.patientservice.services;

import com.sarahhospital.patientservice.exceptions.NoSuchPatientException;
import com.sarahhospital.patientservice.model.HumanName;
import com.sarahhospital.patientservice.repository.PatientRepository;
import com.sarahhospital.patientservice.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findPatientByName(HumanName humanName) {
        return patientRepository.findByName(humanName).orElseThrow(() -> new NoSuchPatientException("There is no patient with such name"));
    }

    public Patient findPatientById(Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new NoSuchPatientException("There is no patient with such id"));
    }

    public Integer createPatient(Patient patient){
        return patientRepository.save(patient).getId();
    }

    public Integer updatePatient(Patient patient) throws RuntimeException{
        return patientRepository.save(patient).getId();
    }

    public void delete(Patient patient) throws RuntimeException{
        patientRepository.delete(patient);
    }
}
