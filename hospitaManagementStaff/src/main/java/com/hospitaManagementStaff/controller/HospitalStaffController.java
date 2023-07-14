package com.hospitaManagementStaff.controller;

import com.hospitaManagementStaff.entities.HospitalStaff;
import com.hospitaManagementStaff.repositories.HospitalStaffRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class HospitalStaffController {
    private final HospitalStaffRepository staffRepository;

    public HospitalStaffController(HospitalStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    //http://localhost:8080/staff/signup
    @PostMapping("/signup") //Save the user details
    public ResponseEntity<String> signUp(@RequestBody HospitalStaff staff) {
        staffRepository.save(staff);
        return ResponseEntity.ok("Signed up successfully!");
    }
    // http://localhost:8080/staff/login
    @PostMapping("/login") //To signin with username and password
    public ResponseEntity<String> login(@RequestBody HospitalStaff staff) {
        Optional<HospitalStaff> optionalStaff = staffRepository.findByUsername(staff.getUsername());

        if (optionalStaff.isPresent() && optionalStaff.get().getPassword().equals(staff.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
    }
}

