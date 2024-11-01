
package models;

/**
 * LibraryItem interface defines the common structure and behaviors
 * for items in the library such as books and periodicals.
 */
public interface LibraryItem {
    String getId();
    String getTitle();
    String getAuthor();
    String getIsbn();
    String getPublisher();
    int getCopies();
    void setCopies(int copies);
    String getGenre();
}

/**
 * Book class implements LibraryItem and represents different formats of books
 * such as printed, electronic, and audio books.
 */
class Book implements LibraryItem {
    private String id, title, author, isbn, publisher, genre, format;
    private int copies;

    public Book(String id, String title, String author, String isbn, String publisher, int copies, String genre, String format) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.copies = copies;
        this.genre = genre;
        this.format = format; // Can be "Printed", "Electronic", or "Audio"
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getPublisher() { return publisher; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
    public String getGenre() { return genre; }
    public String getFormat() { return format; }
}

/**
 * Periodical class implements LibraryItem and represents printed or electronic periodicals.
 */
class Periodical implements LibraryItem {
    private String id, title, author, isbn, publisher, genre, format;
    private int copies;

    public Periodical(String id, String title, String author, String isbn, String publisher, int copies, String genre, String format) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.copies = copies;
        this.genre = genre;
        this.format = format; // Can be "Printed" or "Electronic"
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getPublisher() { return publisher; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
    public String getGenre() { return genre; }
    public String getFormat() { return format; }
}
