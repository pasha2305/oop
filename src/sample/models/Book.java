package sample.models;

import java.util.Objects;

public class Book implements Cloneable{
    private Integer id;
    private String bookName;
    private String bookAuthor;
    private Integer year;
    private String genre;
    private boolean availability;

    public Book(Integer id, String bookName, String bookAuthor, Integer year, String genre) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.year = year;
        this.genre = genre;
        this.availability = true;
    }

    public Integer getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return availability == book.availability &&
                Objects.equals(id, book.id) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookAuthor, book.bookAuthor) &&
                Objects.equals(year, book.year) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookAuthor, year, genre, availability);
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }
}
