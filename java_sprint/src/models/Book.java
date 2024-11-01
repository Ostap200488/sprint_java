package models;

public class Book implements LibraryItem {
    private String id, title, author, isbn, publisher, genre;
    private int copies;

    public Book(String id, String title, String author, String isbn, String publisher, int copies, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.copies = copies;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getGenre() {
        return genre;
    }
}
