package edu.cscc.designpatterns.exercise;

import edu.cscc.designpatterns.singleton.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplTest {

    private BookRepositoryImpl bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepositoryImpl();
    }

    @Test
    public void itHasNoBooksToBeginWith() {
        assertTrue(bookRepository.readAll().isEmpty());
    }

    @Test
    public void itCanCreateABook() {
        Book book = new Book("The Great Hunt", "Robert Jordan", 5);
        book = bookRepository.create(book);
        assertNotNull(book.getID());
    }

    @Test
    public void itCanReadABookByID() {
        Book book = new Book("The Great Hunt", "Robert Jordan", 5);
        book = bookRepository.create(book);

        Book foundBook = bookRepository.read(book.getID());

        assertEquals(book, foundBook);
    }

    @Test
    public void itCanDeleteABook() {
        Book book = new Book("The Great Hunt", "Robert Jordan", 5);
        book = bookRepository.create(book);

        Book deletedBook = bookRepository.delete(book);
        assertEquals(book, deletedBook);

        assertNull(bookRepository.read(deletedBook.getID()));
    }

    @Test
    public void itCanUpdateABook() {
        Book book = new Book("The Great Hunt", "Robert Jordan", 5);
        book = bookRepository.create(book);
        book.setCopies(5);

        bookRepository.update(book);

        Book foundBook = bookRepository.read(book.getID());
        assertEquals(5, foundBook.getCopies());
    }
}