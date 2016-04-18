package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by shion on 15/04/2016.
 */
public class LibraryTest {
    @Test
    public void getListOfBooks() {
        Library library = new Library("Test Library");

        Book book1 = new Book("Test Title 1", "Test Author 1", 2016);
        Book book2 = new Book("Test Title 2", "Test Author 2", 2015);
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> books = library.getBooks();

        assertTrue(books.get(0).getTitle() == "Test Title 1");
        assertTrue(books.get(0).getAuthor() == "Test Author 1");
        assertTrue(books.get(0).getYearPublished() == 2016);

        assertTrue(books.get(1).getTitle() == "Test Title 2");
        assertTrue(books.get(1).getAuthor() == "Test Author 2");
        assertTrue(books.get(1).getYearPublished() == 2015);
    }
}