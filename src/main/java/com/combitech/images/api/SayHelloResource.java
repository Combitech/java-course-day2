package com.combitech.images.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("api/sayhello")
public interface SayHelloResource {

    @GET
    String sayHello();

    @GET
    @Path("jsonhello")
    @Produces(MediaType.APPLICATION_JSON)
    HelloWorld sayHelloJson(@QueryParam("name") String name);

    @GET
    @Path("jsonhello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    HelloWorld sayHelloJsonPathParam(@PathParam("name") String name);


}
