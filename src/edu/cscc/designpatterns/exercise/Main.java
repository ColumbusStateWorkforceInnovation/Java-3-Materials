package edu.cscc.designpatterns.exercise;

import edu.cscc.designpatterns.singleton.Book;
import edu.cscc.designpatterns.singleton.Library;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        Book book = new Book("The Belgariad", "David Eddings", 1);
        Book secondBook = new Book("The Stand", "Stephen King", 2);

        library.addBooks(Arrays.asList(book, secondBook));
        library.getBooks().stream().forEach(addedBook -> {
            System.out.println(addedBook.getName());
        });
    }
}
