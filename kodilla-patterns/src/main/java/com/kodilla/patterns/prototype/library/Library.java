package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public String toString() {

        String s = "List of books in library "+ name;
        for (Book book:books) {
            s = s + "\n" + book.toString();
        }
        return s +"\n";
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book: books) {
            Book clonedBook = new Book(book.getTitle(),book.getAuthor(),book.getPublicationDate());
            clonedLibrary.getBooks().add(clonedBook);
        }
        return clonedLibrary;
    }
}