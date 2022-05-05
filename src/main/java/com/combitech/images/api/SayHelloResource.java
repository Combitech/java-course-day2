package com.combitech.images.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/sayhello")
public interface SayHelloResource {

    @GET
    String sayHello();

    @GET
    @Path("jsonhello")
    @Produces(MediaType.APPLICATION_JSON)
    HelloWorld sayHelloJson();


}
