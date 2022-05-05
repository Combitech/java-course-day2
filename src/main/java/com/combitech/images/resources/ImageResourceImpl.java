package com.combitech.images.resources;

import com.combitech.images.api.ImageResource;

import javax.ws.rs.core.Response;

public class ImageResourceImpl implements ImageResource {
    @Override
    public Response getImage(Long id) {
        return null;
    }

    @Override
    public Response deleteImage(Long id) {
        return null;
    }

    @Override
    public Response uploadImage(byte[] image, Long id) {
        return null;
    }
}
