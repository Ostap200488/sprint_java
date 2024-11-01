package services;

import models.LibraryItem;
import models.Patron;

import java.util.Date;

public class Reservation {
    private Patron patron;
    private LibraryItem item;
    private Date reservationDate;

    public Reservation(Patron patron, LibraryItem item) {
        this.patron = patron;
        this.item = item;
        this.reservationDate = new Date();
    }

    public Patron getPatron() {
        return patron;
    }

    public LibraryItem getItem() {
        return item;
    }

    public Date getReservationDate() {
        return reservationDate;
    }
}
