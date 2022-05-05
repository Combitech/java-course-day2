package com.combitech.images.resources;

import com.combitech.images.api.ImageResource;
import io.minio.*;
import io.minio.errors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ImageResourceImpl implements ImageResource {

    private final MinioClient minioClient;
    private final String minioBucket;
    private final static Logger LOG = LoggerFactory.getLogger(ImageResourceImpl.class);

    public ImageResourceImpl(MinioClient minioClient, String minioBucket) {
        this.minioClient = minioClient;
        this.minioBucket = minioBucket;
    }


    @Override
    public Response getImage(Long id) {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                        .bucket(minioBucket)
                        .object(id.toString())
                        .build();
        try {
            GetObjectResponse response =  minioClient.getObject(getObjectArgs);
            return Response.status(Response.Status.OK).entity(response.readAllBytes()).build();
        }
        catch(ErrorResponseException e){
            throw new WebApplicationException(404);
        }
        catch ( InsufficientDataException | InternalException | InvalidKeyException
                | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException e) {
            LOG.error("Error getting image: ", e);
            throw new WebApplicationException(500);
        }
    }

    @Override
    public Response deleteImage(Long id) {
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                .bucket(minioBucket)
                .object(id.toString())
                .build();
        try {
            minioClient.removeObject(removeObjectArgs);
            return Response.noContent().build();
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException
                | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException e) {
            LOG.error("Error deleting image: ", e);
            throw new WebApplicationException(500);
        }
    }

    @Override
    public Response uploadImage(byte[] image, Long id) {
        ByteArrayInputStream imageStream = new ByteArrayInputStream(image);
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(minioBucket)
                .object(id.toString()).stream(imageStream, imageStream.available(), -1)
                .build();
        try {
            ObjectWriteResponse response = minioClient.putObject(putObjectArgs);
            return Response.status(Response.Status.CREATED).entity(response.object()).build();
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException
                | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException e) {
            LOG.error("Error uploading image: ", e);
            throw new WebApplicationException(500);
        }
    }
}
