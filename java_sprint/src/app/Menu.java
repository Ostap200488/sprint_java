package app;

import models.*;
import services.Library;
import utils.Formatter;
import utils.InputValidator;

public class Menu {
    private Library library = new Library();

    public void displayMenu() {
        while (true) {
            Formatter.displayLine();
            Formatter.displayMessage("Library Management System");
            Formatter.displayLine();
            System.out.println("1. Add Library Item");
            System.out.println("2. Borrow Library Item");
            System.out.println("3. Return Library Item");
            System.out.println("4. Exit");
            int choice = InputValidator.getInt("Select an option: ");

            switch (choice) {
                case 1 -> addItemMenu();
                case 2 -> borrowItemMenu();
                case 3 -> returnItemMenu();
                case 4 -> {
                    Formatter.displayMessage("Exiting...");
                    return;
                }
                default -> Formatter.displayError("Invalid option. Please try again.");
            }
        }
    }

    private void addItemMenu() {
        String title = InputValidator.getString("Enter item title: ");
        String author = InputValidator.getString("Enter author: ");
        String isbn = InputValidator.getString("Enter ISBN: ");
        String publisher = InputValidator.getString("Enter publisher: ");
        int copies = InputValidator.getInt("Enter number of copies: ");
        String genre = InputValidator.getString("Enter genre: ");
        LibraryItem item = new Book(title.hashCode() + "", title, author, isbn, publisher, copies, genre);
        library.addItem(item);
        Formatter.displayMessage("Library item added successfully.");
    }

    private void borrowItemMenu() {
        String title = InputValidator.getString("Enter the title of the item to borrow: ");
        library.searchItem(title).ifPresentOrElse(item -> {
            Patron patron = createPatronMenu();
            if (library.borrowItem(patron, item)) {
                Formatter.displayMessage("Item borrowed successfully.");
            } else {
                Formatter.displayMessage("Item is currently unavailable. You've been added to the reservation list.");
            }
        }, () -> Formatter.displayError("Item not found."));
    }

    private void returnItemMenu() {
        String title = InputValidator.getString("Enter the title of the item to return: ");
        library.searchItem(title).ifPresentOrElse(item -> {
            Patron patron = createPatronMenu();
            boolean isLate = InputValidator.getYesNo("Was the item returned late?");
            library.returnItem(patron, item, isLate);
            Formatter.displayMessage("Item returned successfully.");
        }, () -> Formatter.displayError("Item not found."));
    }

    private Patron createPatronMenu() {
        String name = InputValidator.getString("Enter patron name: ");
        String address = InputValidator.getString("Enter patron address: ");
        String phone = InputValidator.getString("Enter patron phone: ");
        return new Student(name, address, phone); // Example: returns a Student
    }
}
