package task2.service;

import task2.models.Book;
import task2.models.Library;
import task2.models.Person;

public interface LibraryService {
    void addLibrary(Library newLibrary);
    Library[] getAllLibrary();
    void addPersonByName(String libName, Person[] allPerson);
    void addBookByName(String libName, Book[] books);
    void findPersonByName(String namePerson);
    void functionBook();
}
