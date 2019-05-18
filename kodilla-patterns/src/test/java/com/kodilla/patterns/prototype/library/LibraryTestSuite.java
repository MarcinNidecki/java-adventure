package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //given
        Library library = new Library("Main library.");
        IntStream.iterate(1, n -> n+1)
                .limit(6)
                .forEach(n -> library.getBooks().add(new Book(("Book nr" + n),"Unknown", LocalDate.of(2000,n,23))));

        //making a shallow clone of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library shallow copy.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Library deepClonedLibrary  = null;
        try {
            deepClonedLibrary  = library.deepCopy();
            deepClonedLibrary .setName("Library deep cloned.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When

        library.getBooks().add(new Book(("Book XX"),"Unknown", LocalDate.of(2000,12,23)));
        //Then
        System.out.print(library);
        System.out.print(clonedLibrary);
        System.out.print(deepClonedLibrary);
        Assert.assertEquals(7,library.getBooks().size());
        Assert.assertEquals(7,clonedLibrary.getBooks().size());
        Assert.assertEquals(6,deepClonedLibrary.getBooks().size());
    }

}
