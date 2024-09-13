package com.combitech.aircraft.resources;

import com.combitech.aircraft.model.Aircraft;
import com.combitech.aircraft.model.AircraftDto;
import com.combitech.aircraft.model.AircraftType;
import com.combitech.aircraft.model.Owner;
import com.combitech.aircraft.services.AircraftService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("api/aircraft")
public class AircraftResource {

    private final AircraftService aircraftService;


    public AircraftResource(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
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
        return aircraftService.getAircraft(reg);
    }

    @DELETE
    @Path("{reg}")
    public Response deleteAircraft(@PathParam("reg") String reg) {
        aircraftService.deleteAircraft(reg);
        return Response.noContent().build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Aircraft createAircraft(@Valid AircraftDto aircraftDto) {
        return aircraftService.createAircraft(aircraftDto);
    }

    @PUT
    @Path("{reg}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Aircraft updateAircraft(@PathParam("reg") String reg, @Valid AircraftDto aircraftDto) {
        return aircraftService.updateAircraft(reg, aircraftDto);
    }




}
