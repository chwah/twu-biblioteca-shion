package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by shion on 15/04/2016.
 */
public class Library {
    private String name;
    private ArrayList<Book> books;
    private final int INPUT_TO_QUIT = 5;

    Library(String name) {
        this.name = name;
        books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) throws Exception {
        if (book.getTitle().length() > 0 && book.getAuthor().length() > 0 && book.getYearPublished() > 0) {
            books.add(book);
            return;
        }
        throw new Exception("Book not valid");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book getBookWithTitle(String bookTitle) throws Exception {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(bookTitle)) return b;
        }
        throw new Exception("Book not found");
    }

    public void listBooks() {
        System.out.println("List All Books");

        int counter = 0;
        for (Book b : books) {
            if (b.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + b.getTitle());
            }
        }

        if (counter == 0) System.out.println("There is no book available at the moment.");

        System.out.println();
    }

    public void listBooksWithDetails() {
        System.out.println("List All Books with Details");

        int counter = 0;
        for (Book b : books) {
            if (b.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + b.toString());
            }
        }

        if (counter == 0) System.out.println("There is no book available at the moment.");

        System.out.println();
    }

    public void runLibrary() {
        System.out.println("Welcome to " + name + " Management System");
        runMainMenu();
    }

    private void runMainMenu() {
        int input = -1;
        while (input != INPUT_TO_QUIT) {
            showMenu();
            input = InputProcessor.getUserInputAsInteger();

            switch (input) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    listBooksWithDetails();
                    break;
                case 3:
                    showCheckOutMenu();
                    break;
                case 4:
                    showReturnMenu();
                    break;
                case 5:
                    break;
                default:
                    showInvalidInput();
                    break;
            }
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
        System.out.print(str);
    }

    private void showInvalidInput() {
        System.out.println("Select a valid option!\n");
    }

    private void showCheckOutMenu() {
        System.out.print("Enter Title to Borrow: ");
        String bookTitle = InputProcessor.getUserInputAsString();
        checkOutWithBookTitle(bookTitle);
        System.out.println();
    }

    private void showReturnMenu() {
        System.out.print("Enter Title to Return: ");
        String bookTitle = InputProcessor.getUserInputAsString();
        returnWithBookTitle(bookTitle);
        System.out.println();
    }

    protected boolean checkOutWithBookTitle(String bookTitle) {
        Book book;
        try {
            book = getBookWithTitle(bookTitle);

            if (book.isAvailable()) {
                System.out.println("Thank you! Enjoy the book.");
                book.setCheckedOut(true);
                return true;
            } else {
                System.out.println("The book is not available.");
                return false;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

    protected boolean returnWithBookTitle(String bookTitle) {
        Book book;
        try {
            book = getBookWithTitle(bookTitle);

            if (!book.isAvailable()) {
                System.out.println("Thank you for returning the book.");
                book.setCheckedOut(false);
                return true;
            } else {
                System.out.println("That is not a valid book to return.");
                return false;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

}
