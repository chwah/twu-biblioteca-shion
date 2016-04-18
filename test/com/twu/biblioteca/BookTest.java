package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shion on 15/04/2016.
 */
public class BookTest {
    @Test
    public void bookIsValid() {
        Book book = new Book("Test Title", "Test Author", 2016);
        assertTrue(book.getTitle() == "Test Title");
        assertTrue(book.getAuthor() == "Test Author");
        assertTrue(book.getYearPublished() == 2016);
    }

    @Test
    public void bookIsAvailable() {
        Book book = new Book("Test Title", "Test Author", 2016);
        book.setCheckedOut(true);
        assertTrue(book.isAvailable() == false);
    }

    @Test
    public void bookIsNotAvailable() {
        Book book = new Book("Test Title", "Test Author", 2016);
        book.setCheckedOut(false);
        assertTrue(book.isAvailable() == true);
    }
}