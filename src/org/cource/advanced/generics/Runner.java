package org.cource.advanced.generics;

import org.cource.advanced.generics.beans.AudioBook;
import org.cource.advanced.generics.beans.AudioBookLibrary;
import org.cource.advanced.generics.beans.Book;
import org.cource.advanced.generics.beans.GenericMethodExample;
import org.cource.advanced.generics.beans.Library;
import org.cource.advanced.generics.homework.GenericMethod;
import org.cource.advanced.generics.homework.VerySpecificAudioBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        lactureExamples();
        homeWork();
    }

    private static void homeWork() {
        // TODO: 1 Fix compilation errors and warnings
        task1();

        // TODO: 2 Update GenericMethod.populateCollectionWithAudioBook method to get rid of static casts
        task2();

        // TODO: 3 Fix AudioBookLibrary so it will have type param T that may be either AudioBook or any of it child.
        task3();

    }

    private static void task3() {
        var library1 = new AudioBookLibrary<AudioBook>();
        library1.addBook(new AudioBook());
        library1.addBook(new VerySpecificAudioBook());

        var library2 = new AudioBookLibrary<VerySpecificAudioBook>();
        library2.addBook(new AudioBook()); // have to be a compilation error
        library2.addBook(new VerySpecificAudioBook());

        var library3 = new AudioBookLibrary<Book>(); // have to be a compilation error
    }

    private static void task2() {
        List<Book> booksList = new ArrayList<Book>();
        Set<Book> booksSet = new HashSet<>();
        Set<AudioBook> audioBookSet = new HashSet<>();

        booksList = (List<Book>) GenericMethod.populateCollectionWithAudioBook(booksList);
        booksSet = (Set<Book>) GenericMethod.populateCollectionWithAudioBook(booksSet);
        audioBookSet = (Set<AudioBook>) GenericMethod.populateCollectionWithAudioBook(audioBookSet);
    }

    private static void task1() {
        var list1 = new ArrayList<>();
        list1.add("string");
        String str = list1.get(0);

        var list2 = new ArrayList();
        list1.add(new AudioBook());
        list1.add(new Book());


        // pay attention on get and put methods calls for <? extends Book> and <? super Book> lists
        List<? super Book> list3 = new ArrayList<Book>(); // it means List<T> where T either Book or Object
        list3.add(new AudioBook());
        list3.add(new Book());
        AudioBook audioBook3 = list3.get(0);
        Book book3 = list3.get(0);

        List<? extends Book> list4 = new ArrayList<AudioBook>(); // it means List<T> where T either Book or AudioBook
        list4.add(new AudioBook());
        list4.add(new Book());
        AudioBook audioBook4 = list4.get(0);
        Book book4 = list4.get(0);
    }

    private static void lactureExamples() {
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
        List<String> strings = Arrays.asList("", "", "");
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
