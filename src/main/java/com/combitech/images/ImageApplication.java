package com.combitech.images;

import com.combitech.images.resources.SayHelloResourceImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ImageApplication extends Application<ImageConfiguration> {

    @Override
    public void run(ImageConfiguration imageConfiguration, Environment environment) {
        environment.jersey().register(new SayHelloResourceImpl());
    }

    public static void main(String[] args) throws Exception {
        new ImageApplication().run(args);
    }
}
