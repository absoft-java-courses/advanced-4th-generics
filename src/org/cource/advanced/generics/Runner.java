package org.cource.advanced.generics;

import org.cource.advanced.generics.beans.AudioBook;
import org.cource.advanced.generics.beans.AudioBookLibrary;
import org.cource.advanced.generics.beans.Book;
import org.cource.advanced.generics.beans.GenericMethodExample;
import org.cource.advanced.generics.beans.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Runner {
    public static void main(String[] args) {
        // 1. generics in collections: List<>, Set<>, Map<>
        // 3. <T extends MyType>
        genreicClassesExamples();


        // 2. generics for methods like: Arrays.asList()
        genericMethodsExamples();

        // 4. <?>, <? extends MyType>
        genericsWithWirldcardExamples();


        extraExamples();
    }

    private static void extraExamples() {
        Optional.of("")
                .filter(s -> s.length() != 0);

        var arrayList = new ArrayList();
        arrayList.add("asdasd");

        String obj = (String) arrayList.get(0);

        Library<Book> bean = GenericMethodExample.getBean("name");
    }

    private static void genericsWithWirldcardExamples() {
        Class<? extends String> aClass = "".getClass();
        var bookList = Arrays.asList(new AudioBook(), new AudioBook());
        GenericMethodExample.printMyListType(bookList);
    }

    private static void genericMethodsExamples() {
        List<String > strings = Arrays.asList("", "", "");
        List<Book> books = Arrays.asList(new AudioBook(), new Book());

        GenericMethodExample.printMyType("test");
        GenericMethodExample.printMyType(new AudioBook());
    }

    private static void genreicClassesExamples() {
        var list = new ArrayList<String>();
        list.add("123");
        var list1 = new ArrayList<Integer>();
        list1.add(123);

        var library = new Library<Book>();
        library.addBook(new Book());
        library.addBook(new AudioBook());

        var audioBookLibrary = new Library<AudioBook>();
        audioBookLibrary.addBook(new AudioBook());

        var audioBookLibrary1 = new AudioBookLibrary();
        audioBookLibrary1.addBook(new AudioBook());

        new HashMap<Integer, String>();
    }
}
