package com.kodilla.stream.book;

public final class Book {
    private final String author;
    private final String title;
    private final String signature;
    private final int yearOfPublication;

    public Book(final String author, final String title, final String signature, final int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.signature = signature;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", signature='" + signature + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }

    public String getSignature() {
        return signature;
    }
}
