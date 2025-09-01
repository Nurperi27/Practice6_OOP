package task2.service;
import task2.models.Book;

public interface BookService {
    void addBook(Book newBook);
    Book[] getAllBook();
    Book findBookByName(String nameBook);
    void updateBookByAuthorBook(String author, Book newBook);
    void deleteBookByName(String nameBook);
}
