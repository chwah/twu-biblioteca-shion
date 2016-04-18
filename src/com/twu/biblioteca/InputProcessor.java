package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by shion on 18/04/2016.
 */
public class InputProcessor {
    public static int getUserInputAsInteger() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) return scanner.nextInt();
        return -1;
    }

    public static String getUserInputAsString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
