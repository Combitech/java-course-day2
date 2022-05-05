package com.combitech.images;

import io.dropwizard.Configuration;

public class ImageConfiguration extends Configuration {

    private String minioEndpoint;

    public String getMinioEndpoint() {
        return minioEndpoint;
    }

    public void setMinioEndpoint(String minioEndpoint) {
        this.minioEndpoint = minioEndpoint;
    }
}
