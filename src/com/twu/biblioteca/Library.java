package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shion on 15/04/2016.
 */
public class Library {
    String name;
    ArrayList<Book> books;
    final int INPUT_TO_QUIT = 5;

    Library(String name) {
        this.name = name;
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle());
        }
    }

    public void listBooksWithDetails() {
        for (Book b : books) {
            System.out.println(b.toString());
        }
    }

    public void runLibrary() {
        System.out.println("Welcome to " + name + " Management System");
        runMainMenu();
    }

    private void runMainMenu() {
        int input = 0;
        while (input != INPUT_TO_QUIT) {
            showMenu();
            getMenuInput();
        }
    }
    private void showMenu() {
        String str = "";
        str += "1. List Books\n";
        str += "2. List Books with Details\n";
        str += "3. Checkout Book\n";
        str += "4. Return Book\n";
        str += "5. Quit\n\n";
        str += "Input: ";

        System.out.println(str);
    }

    private int getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        return input;
    }

}
