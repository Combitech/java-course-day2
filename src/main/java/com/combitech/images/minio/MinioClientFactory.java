package com.combitech.images.minio;

import io.minio.MinioClient;

public class MinioClientFactory {

    public static MinioClient getMinioClient(String accessKey, String secretKey, String endpoint) {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
