package models;

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
