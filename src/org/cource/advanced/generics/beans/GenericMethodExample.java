package org.cource.advanced.generics.beans;

import java.util.List;

public class GenericMethodExample {

    public static <T> void printMyType(T object) {
        T stuff = object;

        System.out.println("My type is " + object.getClass().getName());;
    }

    public static void printMyListType(List<? extends Book> list) {
        System.out.println(list.getClass().getName());
    }

    public static <T extends Book> void printMyListType1(List<T> list) {
        System.out.println(list.getClass().getName());
    }

    public static <T> T getBean(String name) {
        T obj = null;
        return (T) obj;
    }
}
