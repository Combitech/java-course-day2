package com.combitech.aircraft.resources;

import com.combitech.aircraft.model.HelloWorld;
import com.combitech.aircraft.model.HelloWorldRecord;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("api/hello")
public interface SayHelloResource {

    @GET
    String sayHello();

    @GET
    @Path("jsonhello")
    @Produces(MediaType.APPLICATION_JSON)
    HelloWorld sayHelloJson();

    @GET
    @Path("jsonhellorecord")
    @Produces(MediaType.APPLICATION_JSON)
    HelloWorldRecord sayHelloJsonRecord();

}
