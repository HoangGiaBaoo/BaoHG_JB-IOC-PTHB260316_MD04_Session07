package org.example.patient.dto;

public record PatientResponse(
        Long id,
        String fullName,
        String address,
        String medicalHistory
) {
}
