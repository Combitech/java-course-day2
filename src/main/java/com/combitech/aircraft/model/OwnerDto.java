package com.combitech.aircraft.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record OwnerDto(@NotEmpty String name, @NotEmpty @Size(min = 10, max = 50) String address) {}
