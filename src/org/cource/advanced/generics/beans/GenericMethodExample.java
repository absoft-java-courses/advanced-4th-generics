package org.cource.advanced.generics.beans;

public class GenericMethodExample<T> {

    public <T> void printMyType(T object) {
        System.out.println("My type is " + object.getClass().getName());;
    }
}
