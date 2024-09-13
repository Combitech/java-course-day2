package com.combitech.aircraft.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AircraftDto(@NotNull @Size(min = 2, max = 14) String reg, long ownerId, long typeId) {
}
