package sample.models;

public class Book {
    String bookName;
    String bookAuthor;
    Integer year;
    String genre;

    public Book(String bookName, String bookAuthor, Integer year, String genre) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.year = year;
        this.genre = genre;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
