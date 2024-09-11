package com.combitech.aircraft.resources;

import com.combitech.aircraft.model.AircraftType;
import com.combitech.aircraft.model.AircraftTypeDto;
import com.combitech.aircraft.services.AircraftTypeService;
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

@Path("api/aircraft/type")
public class AircraftTypeResource {

    private final AircraftTypeService aircraftTypeService;

    public AircraftTypeResource(AircraftTypeService aircraftTypeService) {
        this.aircraftTypeService = aircraftTypeService;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AircraftType getAircraftType(@PathParam("id") long id) {
          AircraftType type = aircraftTypeService.getType(id);
          if(type == null) {
              throw new NotFoundException("AircraftType not found for id: " + id);
          }
          return type;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AircraftType createAircraftType(@Valid AircraftTypeDto aircraftType) {
            return aircraftTypeService.saveType(aircraftType);
    }

    @DELETE
    @Path("{id}")
    public Response deleteAircraftType(@PathParam("id") long id) {
        aircraftTypeService.deleteAircraftType(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AircraftType updateAircraftType(@PathParam("id") long id, @Valid AircraftTypeDto aircraftTypeDto) {
        return aircraftTypeService.updateAircraftType(id, aircraftTypeDto);
    }

}
