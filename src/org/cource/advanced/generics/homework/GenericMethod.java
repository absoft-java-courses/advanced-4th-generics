package org.cource.advanced.generics.homework;

import org.cource.advanced.generics.beans.AudioBook;

import java.util.Collection;

public class GenericMethod {
    public static Collection populateCollectionWithAudioBook(Collection collection) {

        collection.add(new AudioBook());

        return collection;
    }
}
