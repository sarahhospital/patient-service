package com.sarahhospital.patientservice.controllers;

import com.sarahhospital.patientservice.model.Patient;
import com.sarahhospital.patientservice.services.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("/patient")
    public Long createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }
}
