package com.combitech.images;

import io.dropwizard.Configuration;

public class ImageConfiguration extends Configuration {

    private String minioEndpoint;

    private String minioAccesKey;

    private String minioSecretKey;

    private String minioBucket;

    public String getMinioEndpoint() {
        return minioEndpoint;
    }

    public void setMinioEndpoint(String minioEndpoint) {
        this.minioEndpoint = minioEndpoint;
    }

    public String getMinioAccesKey() {
        return minioAccesKey;
    }

    public void setMinioAccesKey(String minioAccesKey) {
        this.minioAccesKey = minioAccesKey;
    }

    public String getMinioSecretKey() {
        return minioSecretKey;
    }

    public void setMinioSecretKey(String minioSecretKey) {
        this.minioSecretKey = minioSecretKey;
    }

    public String getMinioBucket() {
        return minioBucket;
    }

    public void setMinioBucket(String minioBucket) {
        this.minioBucket = minioBucket;
    }
}
