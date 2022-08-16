package org.cource.advanced.generics.beans;

import java.util.ArrayList;
import java.util.List;

public class Library <T extends Book> {
    private final List<T> list = new ArrayList<>();

    public void addBook(T book) {
        T book1 = book;

        list.add(book);
    }

    public T getBook(int index) {
        return list.get(index);
    }
}
