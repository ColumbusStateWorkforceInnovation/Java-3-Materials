package edu.cscc.designpatterns.exercise;

import edu.cscc.designpatterns.singleton.Book;

import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    private final Set<Book> books;

    public BookRepositoryImpl() {
        this.books = new HashSet();
    }

    @Override
    public Book create(Book book) {
        Book newBook = new Book(UUID.randomUUID(), book.getName(), book.getAuthor(), book.getCopies());
        books.add(newBook);

        return newBook;
    }

    @Override
    public Book read(UUID id) {
        Optional<Book> found = books.stream().filter(book -> book.getID().equals(id)).findFirst();
        if (found.isPresent()) {
            return found.get();
        }

        return null;
    }

    @Override
    public List<Book> readAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book update(Book book) {
        Book foundBook = read(book.getID());
        foundBook.setName(book.getName());
        foundBook.setAuthor(book.getAuthor());
        foundBook.setCopies(book.getCopies());

        return foundBook;
    }

    @Override
    public Book delete(Book book) {
        books.remove(book);
        return book;
    }


}
