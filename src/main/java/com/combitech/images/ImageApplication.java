package com.combitech.images;

import com.combitech.images.minio.MinioClientFactory;
import com.combitech.images.resources.ImageResourceImpl;
import com.combitech.images.resources.SayHelloResourceImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.minio.MinioClient;

public class ImageApplication extends Application<ImageConfiguration> {

    @Override
    public void run(ImageConfiguration imageConfiguration, Environment environment) {
        MinioClient minioClient = MinioClientFactory.getMinioClient(imageConfiguration.getMinioAccesKey()
                , imageConfiguration.getMinioSecretKey()
                , imageConfiguration.getMinioEndpoint());
        environment.jersey().register(new SayHelloResourceImpl());
        environment.jersey().register(new ImageResourceImpl(minioClient, imageConfiguration.getMinioBucket()));
    }

    public static void main(String[] args) throws Exception {
        new ImageApplication().run(args);
    }
}
