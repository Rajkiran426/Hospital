package com.hospitaManagementStaff.controller;

import com.hospitaManagementStaff.entities.Patient;
import com.hospitaManagementStaff.repositories.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // http://localhost:8080/patients/add
    @PostMapping("/add")  // To save the patients details into database with status like admitted
    public ResponseEntity<String> admitPatient(@RequestBody Patient patient) {
        patient.setStatus("admitted");
        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.ok("Patient admitted successfully!");
    }
    // http://localhost:8080/patients/getAll
    @GetMapping("/getAll") // To get the all patients details from database
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

        // http://localhost:8080/patients/{patientId}
    @DeleteMapping("/{patientId}") //To make the status discharged for saved patient.
    public ResponseEntity<String> dischargePatient(@PathVariable Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setStatus("discharged");
            patientRepository.save(patient);
            return ResponseEntity.ok("Patient discharged successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

