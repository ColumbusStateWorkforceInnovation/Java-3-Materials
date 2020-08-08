package edu.cscc.designpatterns.singleton;

public class Book {

    private String name;
    private String author;
    private int copies;

    public Book(String name, String author, int copies) {
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
}
