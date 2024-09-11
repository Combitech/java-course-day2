package com.combitech.aircraft.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AircraftType {

    private final long id;

    @NotEmpty
    @Size(min = 2, max = 4)
    private final String typeCode;

    @NotEmpty
    @Size(max = 10)
    private final String version;

    @Positive
    private final int mtow;

    public AircraftType(long id, String typeCode
            , String version, int mtow) {
        this.id = id;
        this.typeCode = typeCode;
        this.version = version;
        this.mtow = mtow;
    }

    public long getId() {
        return id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getVersion() {
        return version;
    }

    /**
     *
     * @return the maximum takeoff weight (mtow) for the aircraft
     *
     * */
    public int getMtow() {
        return mtow;
    }
}
