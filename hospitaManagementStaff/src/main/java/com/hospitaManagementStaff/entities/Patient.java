package com.hospitaManagementStaff.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String room;

    private String doctorName;
    @Temporal(TemporalType.DATE)
    private Date admitDate;

    private double expenses;

    private String status;

    // Constructors, getters, and setters
}

