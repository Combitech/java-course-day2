package com.combitech.images.resources;

import com.combitech.images.api.HelloWorld;
import com.combitech.images.api.HelloWorldRecord;
import com.combitech.images.api.SayHelloResource;

public class SayHelloResourceImpl implements SayHelloResource {
    @Override
    public String sayHello() {
        return "Hello World";
    }

    @Override
    public HelloWorld sayHelloJson(String name) {
        HelloWorld hello = new HelloWorld(1, "Hello " + name);
        return hello;
    }

    @Override
    public HelloWorld sayHelloJsonPathParam(String name) {
        HelloWorld hello = new HelloWorld(1, "Hello " + name);
        return hello;
    }
}
