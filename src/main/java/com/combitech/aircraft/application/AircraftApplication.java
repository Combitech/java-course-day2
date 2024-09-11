package com.combitech.aircraft.application;

import com.combitech.aircraft.resources.AircraftResource;
import com.combitech.aircraft.resources.AircraftTypeResource;
import com.combitech.aircraft.resources.OwnerResource;
import com.combitech.aircraft.resources.SayHelloResourceImpl;
import com.combitech.aircraft.services.AircraftTypeService;
import com.combitech.aircraft.services.OwnerService;
import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Environment;

public class AircraftApplication extends Application<Configuration> {
    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new SayHelloResourceImpl());
        environment.jersey().register(new AircraftResource());
        environment.jersey().register(new AircraftTypeResource(new AircraftTypeService()));
        environment.jersey().register(new OwnerResource(new OwnerService()));
    }

    public static void main(String[] args) throws Exception {
        new AircraftApplication().run(args);
    }
}
