package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Patron {
    private String name, address, phone;
    private List<LibraryItem> borrowedItems;
    private double fines;

    public Patron(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.borrowedItems = new ArrayList<>();
        this.fines = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public double getFines() {
        return fines;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void addFine(double amount) {
        fines += amount;
    }
}
