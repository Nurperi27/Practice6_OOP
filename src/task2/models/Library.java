package task2.models;

import java.time.LocalDate;
import java.util.Arrays;

public class Library {
    private String nameLibrary;
    private String address;
    private LocalDate date;
    private Book[] books;
    private Person[] persons;
    public Library(){}
    public Library(String nameLibrary, String address, LocalDate date, Book[] books, Person[] persons) {
        this.nameLibrary = nameLibrary;
        this.address = address;
        this.date = date;
        this.books = books;
        this.persons = persons;
    }
    public Library(String nameLibrary, String address, LocalDate date) {
        this.nameLibrary = nameLibrary;
        this.address = address;
        this.date = date;
    }
    public String getNameLibrary() {
        return nameLibrary;
    }
    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }
    public Person[] getPersons() {
        return persons;
    }
    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Library{" +
                "NameLibrary: " + nameLibrary + '\'' +
                ", Address: " + address + '\'' +
                ", Date: " + date +
                ", \nBooks: " + Arrays.toString(books) +
                ", \nPersons: " + Arrays.toString(persons) +
                '}';
    }
}
