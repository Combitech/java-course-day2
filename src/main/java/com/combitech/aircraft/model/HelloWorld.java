package com.combitech.aircraft.model;

public class HelloWorld {

    private final int id;

    private final String text;

    public HelloWorld(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }
}
