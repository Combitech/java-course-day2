package com.combitech.aircraft.resources;

import com.combitech.aircraft.model.HelloWorld;
import com.combitech.aircraft.model.HelloWorldRecord;

public class SayHelloResourceImpl implements SayHelloResource {

    @Override
    public String sayHello() {
        return "Hello, World!";
    }

    @Override
    public HelloWorld sayHelloJson() {
        return new HelloWorld(1, "Hello, World");
    }

    @Override
    public HelloWorldRecord sayHelloJsonRecord() {
        return new HelloWorldRecord(2, "Hello, World from record");
    }
}
