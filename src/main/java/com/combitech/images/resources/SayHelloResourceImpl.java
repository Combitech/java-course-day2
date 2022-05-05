package com.combitech.images.resources;

import com.combitech.images.api.HelloWorld;
import com.combitech.images.api.SayHelloResource;

public class SayHelloResourceImpl implements SayHelloResource {
    @Override
    public String sayHello() {
        return "Hello World";
    }

    @Override
    public HelloWorld sayHelloJson() {
        return new HelloWorld(1, "Hello World");
    }
}
