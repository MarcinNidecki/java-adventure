package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedian() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        Book book1 = new Book("Adam Mickiewicz", "Dziady cz.3", 2001,"2020/AM280231");
        Book book2 = new Book("Adam Mickiewicz", "Pan Tadeusz", 2001,"2022/AM280231");
        Book book3 = new Book("Bolesław Prus", "Lalka", 2001,"2021/AM280231");
        Book book4 = new Book("Stanisław Wyspiański", "Wesele", 2004,"2026/AM280231");
        Book book5 = new Book("Witold Gombrowicz", "Ferdydurke", 2003,"2011/AM280231");
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(median);
        assertEquals(median, 2001,0);
    }

}
