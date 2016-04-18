package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by shion on 15/04/2016.
 */
public class LibraryTest {
    @Test
    public void libraryIsValid() {
        Library library = new Library("Test Library");

        assertTrue(library.getName() == "Test Library");
        assertTrue(library.getBooks().isEmpty() == true);
    }

    @Test
    public void getListOfBooks() {
        Library library = new Library("Test Library");

        Book book1 = new Book("Test Title 1", "Test Author 1", 2016);
        Book book2 = new Book("Test Title 2", "Test Author 2", 2015);
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> books = library.getBooks();
        assertTrue(books.size() == 2);

        assertTrue(books.contains(book1) == true);
        assertTrue(books.get(0).getTitle() == "Test Title 1");
        assertTrue(books.get(0).getAuthor() == "Test Author 1");
        assertTrue(books.get(0).getYearPublished() == 2016);

        assertTrue(books.contains(book2) == true);
        assertTrue(books.get(1).getTitle() == "Test Title 2");
        assertTrue(books.get(1).getAuthor() == "Test Author 2");
        assertTrue(books.get(1).getYearPublished() == 2015);
    }

    @Test
    public void successfullyCheckOutBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author 1", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        assertTrue(library.checkOutWithBookTitle("Available Title") == true);
        assertTrue(book.isAvailable() == false);
    }

    @Test
    public void unsuccessfullyCheckOutBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Unavailable Title", "Test Author 1", 2016);
        book.setCheckedOut(true);
        library.addBook(book);

        assertTrue(library.checkOutWithBookTitle("Unavailable Title") == false);
        assertTrue(library.checkOutWithBookTitle("Non-existent Title") == false);
    }

    @Test
    public void successfullyReturnBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Unavailable Title", "Test Author 1", 2016);
        book.setCheckedOut(true);
        library.addBook(book);

        assertTrue(library.returnWithBookTitle("Unavailable Title") == true);
        assertTrue(book.isAvailable() == true);
    }

    @Test
    public void unsuccessfullyReturnBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author 1", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        assertTrue(library.returnWithBookTitle("Available Title") == false);
        assertTrue(library.returnWithBookTitle("Non-existent Title") == false);
    }
}