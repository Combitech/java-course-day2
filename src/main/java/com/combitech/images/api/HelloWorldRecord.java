package com.combitech.images.api;

// Jackson kollar i klassen efter metoder somn heter getXXXX för att kunna serialisera till JSON
// men i ett Record så döps metoderna till exvis id() och name()
//ett hackigt sätt att komma runt detta är att döpa variablerna till getId och getName
public record HelloWorldRecord(int getId, String getName) {
}
