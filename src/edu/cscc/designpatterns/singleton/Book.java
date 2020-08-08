package edu.cscc.designpatterns.singleton;

import java.util.Objects;
import java.util.UUID;

public class Book {

    private String name;
    private String author;
    private int copies;
    private UUID id;

    public Book(String name, String author, int copies) {
        this.name = name;
        this.author = author;
        this.copies = copies;
    }

    public Book(UUID id, String name, String author, int copies) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.copies = copies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public UUID getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
