package com.combitech.aircraft.resources;

import com.combitech.aircraft.model.Aircraft;
import com.combitech.aircraft.model.AircraftType;
import com.combitech.aircraft.model.Owner;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("api/aircraft")
public class AircraftResource {

    private static final Map<String, Aircraft> aircrafts = new HashMap<>();

    public AircraftResource() {
        aircrafts.put("SEMKA", new Aircraft(1, "SEMKA", new Owner(1, "Braathens Regional", "Abcvägen 123, Stockholm" )
                , new AircraftType(1, "AT76", "202", 8000)));
        aircrafts.put("SEMKB", new Aircraft(2, "SEMKB", new Owner(1, "Braathens Regional", "Abcvägen 123, Stockholm" )
                , new AircraftType(2, "AT72", "204", 9856)));
    }
    /**
     * Gets an aircraft
     * @param reg The registration for the aircraft
     * @return If found, the aircraft with the given registration
     *
     * */
    @GET
    @Path("{reg}")
    @Produces(MediaType.APPLICATION_JSON)
    @Valid
    public Aircraft getAircraft(@PathParam("reg") String reg) {
        Aircraft aircraft = aircrafts.get(reg);
        if(aircraft == null) {
            throw new NotFoundException("No aircraft with reg found: " + reg);
        }
        return aircraft;
    }


}
