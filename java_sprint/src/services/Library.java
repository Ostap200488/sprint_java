package services;

import models.LibraryItem;
import models.Patron;
import models.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public Optional<LibraryItem> searchItem(String query) {
        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(query) ||
                        item.getAuthor().equalsIgnoreCase(query) ||
                        item.getIsbn().equalsIgnoreCase(query))
                .findFirst();
    }

    public List<LibraryItem> searchByGenre(String genre) {
        return items.stream().filter(item -> item.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }

    public boolean borrowItem(Patron patron, LibraryItem item) {
        if (item.getCopies() > 0) {
            item.setCopies(item.getCopies() - 1);
            patron.borrowItem(item);
            return true;
        } else {
            reservations.add(new Reservation(patron, item));
            return false;
        }
    }

    public void returnItem(Patron patron, LibraryItem item, boolean isLate) {
        item.setCopies(item.getCopies() + 1);
        patron.returnItem(item);
        if (isLate) {
            System.out.println("Late return. Adding fine.");
            patron.addFine(10);
        }
        notifyReservation(item);
    }

    private void notifyReservation(LibraryItem item) {
        Optional<Reservation> reservation = reservations.stream()
                .filter(res -> res.getItem().equals(item))
                .findFirst();
        if (reservation.isPresent()) {
            Patron patron = reservation.get().getPatron();
            System.out.println("Notification: Item " + item.getTitle() + " is now available for " + patron.getName());
            reservations.remove(reservation.get());
        }
    }
}
