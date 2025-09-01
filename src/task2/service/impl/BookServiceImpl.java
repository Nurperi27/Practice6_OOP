package task2.service.impl;

import task2.enums.Booked;
import task2.enums.GenreBook;
import task2.models.Book;
import task2.service.BookService;

import java.time.LocalDate;

public class BookServiceImpl implements BookService {
    //todo DB-Array
    Book[] bookArr = new Book[10];
    int countBook;
    @Override
    public void addBook(Book newBook) {
        bookArr[countBook++] = newBook;
        System.out.println("Data-Book is created!");
    }

    @Override
    public Book[] getAllBook() {
        return bookArr;
    }

    @Override
    public Book findBookByName(String nameBook) {
        boolean isblock = false;
        for(Book b : bookArr){
            if(b.getNameBook().equals(nameBook)){
                isblock = true;
                return b;
            }
        }
        return null;
    }

    @Override
    public void updateBookByAuthorBook(String author, Book newBook) {
        for(Book b : bookArr){
            if(b.getAuthor().equals(author)){
                Book oldBook = new Book();
                oldBook.setNameBook(newBook.getNameBook());
                oldBook.setAuthor(newBook.getAuthor());
                oldBook.setIsBooked(newBook.getIsBooked());
                oldBook.setYearEdition(newBook.getYearEdition());
                oldBook.setGenre(newBook.getGenre());
            }
        }
        System.out.println("Data-Book is changed!");
    }

    @Override
    public void deleteBookByName(String nameBook) {
        boolean isblock = false;
        for (int i = 0; i < countBook; i++) {
            if(bookArr[i].getNameBook().equals(nameBook)){
                isblock = true;
                for (int i1 = 0; i1 < countBook - 1; i1++) { //сдигаем элементов после удаления
                    bookArr[i1] = bookArr[i1+1];
                }
                bookArr[countBook - 1] = null; //обнуляем место последнегго элемента
                countBook--; //кол-во элементов уменьшается
                System.out.println("Book deleted!");
                break;
            }
        }
        if(!isblock){
            System.out.println("Such book name not found!");
        }
    }
}
