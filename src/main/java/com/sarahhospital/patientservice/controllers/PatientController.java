package com.sarahhospital.patientservice.controllers;

import com.sarahhospital.patientservice.entity.Patient;
import com.sarahhospital.patientservice.model.HumanName;
import com.sarahhospital.patientservice.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
            return patientService.findPatientById(id);
    }

    @GetMapping("/given/patronymic/family")
    public Patient getPatientByName(@RequestParam String given, @RequestParam String patronymic, @RequestParam String family){
        return patientService.findPatientByName(new HumanName(given, patronymic, family));
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PutMapping("/update")
    public Long updatePatient(@RequestParam Patient patient){
        return patientService.updatePatient(patient);
    }

    @PostMapping("/create")
    public Long createPatient(@RequestParam Patient patient){
        return patientService.createPatient(patient);
    }
}
