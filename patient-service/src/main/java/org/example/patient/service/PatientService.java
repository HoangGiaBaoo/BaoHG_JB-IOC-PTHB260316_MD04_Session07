package org.example.patient.service;

import lombok.RequiredArgsConstructor;
import org.example.patient.dto.PatientRequest;
import org.example.patient.dto.PatientResponse;
import org.example.patient.entity.Patient;
import org.example.patient.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientResponse createPatient(PatientRequest request) {
        Patient patient = Patient.builder()
                .fullName(request.fullName())
                .address(request.address())
                .medicalHistory(request.medicalHistory())
                .build();
        return toResponse(patientRepository.save(patient));
    }

    public PatientResponse getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Không tìm thấy bệnh nhân với id = " + id));
    }

    private PatientResponse toResponse(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getFullName(),
                patient.getAddress(),
                patient.getMedicalHistory());
    }
}
