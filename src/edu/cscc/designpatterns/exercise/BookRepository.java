package edu.cscc.designpatterns.exercise;

import edu.cscc.designpatterns.singleton.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepository {
    Book create(Book book);
    Book read(UUID id);
    List<Book> readAll();
    Book update(Book book);
    Book delete(Book book);
}
