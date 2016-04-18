package com.twu.biblioteca;

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
            library.addBook(book);
        }
    }
}
