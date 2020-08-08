package edu.cscc.designpatterns.singleton;

import edu.cscc.designpatterns.exercise.BookRepository;
import edu.cscc.designpatterns.exercise.BookRepositoryImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Library {

    private static Library instance;
    private BookRepository bookRepository;

    private Library() {
        this.bookRepository = new BookRepositoryImpl();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }

        return instance;
    }

    public void addBooks(Collection<Book> books) {
        books.stream().forEach(book -> {
                bookRepository.create(book);
        });
    }

    public Set<Book> getBooks() {
        return new HashSet<Book>(bookRepository.readAll());
    }
}
