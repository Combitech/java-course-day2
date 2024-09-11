package com.combitech.aircraft.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AircraftTypeDto(@NotEmpty @Size(min = 2, max = 4) String typeCode, @NotEmpty @Size(max = 10) String version, @Positive int mtow) {
}
