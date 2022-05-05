package com.combitech.images.api;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("api/images")
public interface ImageResource {


    /**
     *
     * Gets an image
     *
     * @param id id of the user
     * @return the image
     */
    @GET
    @Path("{id}")
    @Produces({"image/png", "image/jpeg"})
    Response getImage(@PathParam("id") Long id);

    /**
     * Deletes an image
     *
     *  @param id id of the user
     *  @return the image
     */
    @DELETE
    @Path("{id}")
    Response deleteImage(@PathParam("id") Long id);


    /**
     * Creates or updates an image
     *
     *  @param id id of the user
     *  @param image the image as a byte array
     *  @return info about the created image
     */
    @PUT
    @Path("{id}")
    Response uploadImage(byte[] image, @PathParam("id") Long id);


}
