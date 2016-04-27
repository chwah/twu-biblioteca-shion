package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by shion on 15/04/2016.
 */
public class LibraryTest {
    @Test
    public void libraryIsValid() {
        Library library = new Library("Test Library");

        assertTrue(library.getName() == "Test Library");
        assertTrue(library.getBooks().isEmpty());
    }

    @Test
    public void getListOfBooks() throws Exception {
        Library library = new Library("Test Library");
        Book book1 = new Book("Test Title 1", "Test Author 1", 2016);
        Book book2 = new Book("Test Title 2", "Test Author 2", 2015);

        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> books = library.getBooks();

        assertTrue(books.size() == 2);
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void canAddBook() throws Exception {
        Library library = new Library("Test Library");
        Book book = new Book("Available Title", "Test Author", 2016);

        library.addBook(book);

        assertTrue(library.getBooks().contains(book));
    }

    @Test(expected = Exception.class)
    public void cannotAddBook() throws Exception {
        Library library = new Library("Test Library");
        Book book1 = new Book("", "Test Author", 2016);
        Book book2 = new Book("Test Title", "", 2016);
        Book book3 = new Book("Test Title", "Test Author", 0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    public void successfullyCheckOutBook() throws Exception {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        assertTrue(library.checkOutWithBookTitle("Available Title"));
        assertFalse(book.isAvailable());
    }

    @Test
    public void unsuccessfullyCheckOutBook() throws Exception {
        Library library = new Library("Test Library");

        Book book = new Book("Unavailable Title", "Test Author", 2016);
        book.setCheckedOut(true);
        library.addBook(book);

        assertFalse(library.checkOutWithBookTitle("Unavailable Title"));
        assertFalse(library.checkOutWithBookTitle("Non-existent Title"));
    }

    @Test
    public void successfullyReturnBook() throws Exception {
        Library library = new Library("Test Library");

        Book book = new Book("Unavailable Title", "Test Author", 2016);
        book.setCheckedOut(true);
        library.addBook(book);

        assertTrue(library.returnWithBookTitle("Unavailable Title"));
        assertTrue(book.isAvailable());
    }

    @Test
    public void unsuccessfullyReturnBook() throws Exception {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        assertFalse(library.returnWithBookTitle("Available Title"));
        assertFalse(library.returnWithBookTitle("Non-existent Title"));
    }
}