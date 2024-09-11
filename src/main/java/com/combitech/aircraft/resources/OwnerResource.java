package com.combitech.aircraft.resources;

import com.combitech.aircraft.model.Owner;
import com.combitech.aircraft.model.OwnerDto;
import com.combitech.aircraft.services.OwnerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

@Path("api/aircraft/owner")
public class OwnerResource {

    private final OwnerService ownerService;

    public OwnerResource(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Valid
    public Owner getOwner(@PathParam("id") long id) {
        Owner owner = ownerService.getOwner(id);
        if(owner == null) {
            throw new NotFoundException();
        }
        return owner;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Owner createOwner(@Valid @NotNull OwnerDto owner) {
        return ownerService.saveOwner(owner);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Owner updateOwner(@PathParam("id") long id , @Valid @NotNull OwnerDto owner) {
        return ownerService.updateOwner(owner, id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner deleteOwner(@PathParam("id") long id) {
        return ownerService.deleteOwner(id);
    }
}

