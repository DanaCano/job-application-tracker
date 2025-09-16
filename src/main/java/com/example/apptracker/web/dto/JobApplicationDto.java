package com.example.apptracker.web.dto;

import com.example.apptracker.domain.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record JobApplicationDto(
    Long id,
    @NotBlank String company,
    @NotBlank String position,
    @NotNull ApplicationStatus status,
    LocalDate appliedDate,
    String notes
) {}
