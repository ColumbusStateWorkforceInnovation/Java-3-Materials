package edu.cscc.designpatterns.singleton;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Library {

    private static Library instance;
    private Set<Book> books;

    private Library() {
        this.books = new HashSet<Book>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }

        return instance;
    }

    public void addBooks(Collection books) {
        this.books.addAll(books);
    }

    public Set<Book> getBooks() {
        return books;
    }
}
