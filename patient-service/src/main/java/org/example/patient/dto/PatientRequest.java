package org.example.patient.dto;

import jakarta.validation.constraints.NotBlank;

public record PatientRequest(
        @NotBlank(message = "Họ và tên bệnh nhân không được để trống")
        String fullName,
        String address,
        String medicalHistory
) {
}
