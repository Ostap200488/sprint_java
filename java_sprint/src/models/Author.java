package models;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dob;
    private List<LibraryItem> writtenItems;

    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.writtenItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public List<LibraryItem> getWrittenItems() {
        return writtenItems;
    }

    public void addWrittenItem(LibraryItem item) {
        writtenItems.add(item);
    }
}
