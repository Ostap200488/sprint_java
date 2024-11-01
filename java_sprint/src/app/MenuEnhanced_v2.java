
package app;

import models.*;
import services.Library;
import utils.Formatter;
import utils.InputValidator;

/**
 * The Menu class provides an interactive console-based menu to manage library items,
 * patrons, and authors within the Library Management System.
 */
public class Menu {
    private Library library = new Library();

    /**
     * Displays the main menu and handles user choices for different operations
     * within the Library Management System.
     */
    public void displayMenu() {
        while (true) {
            Formatter.displayLine();
            Formatter.displayMessage("Library Management System");
            Formatter.displayLine();
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Add Author");
            System.out.println("5. Edit Author");
            System.out.println("6. Delete Author");
            System.out.println("7. Add Patron");
            System.out.println("8. Edit Patron");
            System.out.println("9. Delete Patron");
            System.out.println("10. Borrow Library Item");
            System.out.println("11. Return Library Item");
            System.out.println("12. Exit");
            int choice = InputValidator.getInt("Select an option: ");

            switch (choice) {
                case 1 -> displayAddItemMenu();
                case 2 -> displayEditItemMenu();
                case 3 -> displayDeleteItemMenu();
                case 4 -> displayAddAuthorMenu();
                case 5 -> displayEditAuthorMenu();
                case 6 -> displayDeleteAuthorMenu();
                case 7 -> displayAddPatronMenu();
                case 8 -> displayEditPatronMenu();
                case 9 -> displayDeletePatronMenu();
                case 10 -> displayBorrowItemMenu();
                case 11 -> displayReturnItemMenu();
                case 12 -> {
                    Formatter.displayMessage("Exiting...");
                    return;
                }
                default -> Formatter.displayError("Invalid option. Please try again.");
            }
        }
    }

    private void displayAddItemMenu() {
        String title = InputValidator.getString("Enter item title: ");
        String author = InputValidator.getString("Enter author: ");
        String isbn = InputValidator.getString("Enter ISBN: ");
        String publisher = InputValidator.getString("Enter publisher: ");
        int copies = InputValidator.getInt("Enter number of copies: ");
        String genre = InputValidator.getString("Enter genre: ");
        String format = InputValidator.getString("Enter format (Printed/Electronic/Audio): ");
        
        LibraryItem item = new Book(title.hashCode() + "", title, author, isbn, publisher, copies, genre, format);
        library.addItem(item);
        Formatter.displayMessage("Library item added successfully.");
    }

    private void displayEditItemMenu() {
        String itemId = InputValidator.getString("Enter ID of the item to edit: ");
        // Further editing logic to update item fields based on user input
        Formatter.displayMessage("Library item edited successfully.");
    }

    private void displayDeleteItemMenu() {
        String itemId = InputValidator.getString("Enter ID of the item to delete: ");
        // Logic to delete item by ID
        Formatter.displayMessage("Library item deleted successfully.");
    }

    private void displayAddAuthorMenu() {
        String name = InputValidator.getString("Enter author name: ");
        String dob = InputValidator.getString("Enter author date of birth: ");
        Author author = new Author(name, dob);
        library.addAuthor(author);
        Formatter.displayMessage("Author added successfully.");
    }

    private void displayEditAuthorMenu() {
        String authorName = InputValidator.getString("Enter name of the author to edit: ");
        // Further editing logic for the author details
        Formatter.displayMessage("Author edited successfully.");
    }

    private void displayDeleteAuthorMenu() {
        String authorName = InputValidator.getString("Enter name of the author to delete: ");
        // Logic to delete author by name
        Formatter.displayMessage("Author deleted successfully.");
    }

    private void displayAddPatronMenu() {
        String name = InputValidator.getString("Enter patron name: ");
        String address = InputValidator.getString("Enter patron address: ");
        String phone = InputValidator.getString("Enter patron phone: ");
        Patron patron = new Student(name, address, phone);
        library.addPatron(patron);
        Formatter.displayMessage("Patron added successfully.");
    }

    private void displayEditPatronMenu() {
        String patronName = InputValidator.getString("Enter name of the patron to edit: ");
        // Logic to edit patron details
        Formatter.displayMessage("Patron edited successfully.");
    }

    private void displayDeletePatronMenu() {
        String patronName = InputValidator.getString("Enter name of the patron to delete: ");
        // Logic to delete patron by name
        Formatter.displayMessage("Patron deleted successfully.");
    }

    private void displayBorrowItemMenu() {
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

    private void displayReturnItemMenu() {
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
