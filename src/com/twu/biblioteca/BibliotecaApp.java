package com.twu.biblioteca;

import javax.sound.midi.SysexMessage;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library biblioteca = new Library("Bangalore Public Library");
        populateLibrary(biblioteca);
        biblioteca.runLibrary();
    }

    private static void populateLibrary(Library library) {
        int totalBooks = 2;
        for (int i = 1 ; i <= totalBooks ; i++) {
            Book book = new Book("Book Title " + i, "Author " + i, 2000 + i);
            try {
                library.addBook(book);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
