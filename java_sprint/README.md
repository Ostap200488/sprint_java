
# Library Management System

## Project Overview
This Library Management System is a Java application that enables the management of library items, authors, and patrons. This project includes functionality to add, edit, and delete library items, authors, and patrons, as well as borrow and return items.

## Features
- **Library Item Management**: Supports Books and Periodicals, with options to add, edit, and delete items.
- **Author Management**: Allows adding, editing, and deleting author information.
- **Patron Management**: Manages patrons, allowing them to borrow and return items.
- **CRUD Operations**: CRUD functionalities are implemented for items, authors, and patrons.
- **Interactive Menu**: Console-based interactive menu for easy navigation.

## Class Structure
### `LibraryItem`
Defines a hierarchy of items (Books, Periodicals) with various attributes (ID, title, author, etc.)

### `Author`
Represents an author with attributes like name, date of birth, and a list of written items.

### `Patron`
Abstract class for patrons, with subtypes like Student and Employee, containing personal details and borrowed items.

### `Library`
Handles the management of library items, authors, and patrons. It also includes methods to search, borrow, and return items.

### `Menu`
Console-based menu using the Scanner class to navigate functionalities.

## Setup
1. **Clone Repository**: Clone this repository from GitHub to your local machine.
2. **Run the Project**: Compile and run the `LibraryManagementSystem` class to start the console application.

## Additional Notes
Ensure Java SDK is installed and environment variables are correctly set.

---
