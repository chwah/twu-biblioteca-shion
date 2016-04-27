package com.twu.biblioteca;

/**
 * Created by shion on 13/04/2016.
 */
public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean isAvailable() {
        return !checkedOut;
    }

    public String toString() {
        String str = "";
        str += "Title: " + getTitle() + ", ";
        str += "Author: " + getAuthor() + ", ";
        str += "Year Published: " + getYearPublished();
        return str;
    }

    public boolean equals(Book book2) {
        return getTitle() == book2.getTitle() && getAuthor() == book2.getAuthor() && getYearPublished() == book2.getYearPublished();
    }
}
