package com.combitech.aircraft.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Aircraft {

    private final long id;

    @NotNull
    @Size(min = 2, max = 14)
    private final String reg;

    @NotNull
    @Valid
    private final Owner owner;

    @NotNull
    @Valid
    private final AircraftType type;

    public Aircraft(long id, String reg, Owner owner, AircraftType type) {
        this.id = id;
        this.reg = reg;
        this.owner = owner;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public @NotNull @Size(min = 2, max = 14) String getReg() {
        return reg;
    }

    public @NotNull @Valid Owner getOwner() {
        return owner;
    }

    public AircraftType getType() {
        return type;
    }
}
