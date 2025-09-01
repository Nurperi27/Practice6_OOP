package task2.models;
import task2.enums.Booked;
import task2.enums.GenreBook;
import java.time.LocalDate;

public class Book {
    private String nameBook;
    private String author;
    private Booked isBooked; //бронь книги
    private LocalDate yearEdition; //дата издания
    private GenreBook genre;
    public Book() {}
    public Book(String nameBook, String author, Booked isBooked, LocalDate yearEdition, GenreBook genre) {
        this.nameBook = nameBook;
        this.author = author;
        this.isBooked = isBooked;
        this.yearEdition = yearEdition;
        this.genre = genre;
    }
    public String getNameBook() {
        return nameBook;
    }
    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Booked getIsBooked() {
        return isBooked;
    }
    public void setIsBooked(Booked isBooked) {
        this.isBooked = isBooked;
    }
    public GenreBook getGenre() {
        return genre;
    }
    public void setGenre(GenreBook genre) {
        this.genre = genre;
    }
    public LocalDate getYearEdition() {
        return yearEdition;
    }
    public void setYearEdition(LocalDate yearEdition) {
        this.yearEdition = yearEdition;
    }
    @Override
    public String toString() {
        return "\nBook{" +
                "NameBook: " + nameBook + '\'' +
                ", Author: " + author + '\'' +
                ", IsBooked: " + isBooked +
                ", YearEdition: " + yearEdition.getYear() +
                ", Genre: " + genre +
                '}';
    }
}
