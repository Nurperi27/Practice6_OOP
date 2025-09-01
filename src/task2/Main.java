package task2;

import task2.enums.Booked;
import task2.enums.Gender;
import task2.enums.GenreBook;
import task2.models.Book;
import task2.models.Library;
import task2.models.Person;
import task2.service.BookService;
import task2.service.LibraryService;
import task2.service.PersonService;
import task2.service.impl.BookServiceImpl;
import task2.service.impl.LibraryServiceImpl;
import task2.service.impl.PersonServiceImpl;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1L, "A", LocalDate.of(2000, 1, 1), Gender.valueOf("FEMALE"));
        Person person2 = new Person(2L, "B", LocalDate.of(2001, 1, 1), Gender.MALE);
        Person person3 = new Person(3L, "C", LocalDate.of(2002, 1, 1), Gender.FEMALE);
        Person[] persons = {person1, person2, person3};
        PersonService personService = new PersonServiceImpl();
        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);
        System.out.println(Arrays.toString(personService.getAll()));
        /*System.out.print("Enter name of person to find: ");
        String namePerson = new Scanner(System.in).nextLine();
        personService.findPersonByName(namePerson);
        Scanner scInt = new Scanner(System.in);
        Person updatePerson = new Person();
        System.out.println("Write old-name person: ");
        String oldName = new Scanner(System.in).nextLine();
        System.out.println("Write new name person: ");
        updatePerson.setNamePerson(new Scanner(System.in).nextLine());
        updatePerson.setDateOfBirth(LocalDate.of(Integer.parseInt(scInt.nextLine()), Integer.parseInt(scInt.nextLine()), Integer.parseInt(scInt.nextLine())));
        updatePerson.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
        personService.updatePersonByName(oldName, updatePerson);
        System.out.print("Enter name person to delete: ");
        personService.deletePersonByName(new Scanner(System.in).nextLine());*/
        System.out.println("__________________________________________________");
        Book book1 = new Book("Aa", "A.A.", Booked.NOT_BOOKED, LocalDate.ofYearDay(1930, 1), GenreBook.NOVEL);
        Book book2 = new Book("Ba", "B.B.", Booked.ISBOOKED, LocalDate.ofYearDay(1931, 1), GenreBook.FANTASY);
        Book book3 = new Book("Ca", "C.C.", Booked.NOT_BOOKED, LocalDate.ofYearDay(1932, 1), GenreBook.DETECTIVE);
        Book book4 = new Book("Da", "D.D.", Booked.ISBOOKED, LocalDate.ofYearDay(1933, 1), GenreBook.THRILLER);
        Book book5 = new Book("Ea", "E.E.", Booked.NOT_BOOKED, LocalDate.ofYearDay(1934, 1), GenreBook.NOVEL);
        Book[] books = {book1, book2, book3, book4, book5};
        BookService bookService = new BookServiceImpl();
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        bookService.addBook(book5);
        System.out.println(Arrays.toString(bookService.getAllBook()));
        System.out.println("__________________________________________________");
        Library library1 = new Library("Q&Q", "q/1", LocalDate.now());
        LibraryService libraryService = new LibraryServiceImpl();
        libraryService.addLibrary(library1);
        libraryService.addPersonByName(library1.getNameLibrary(), persons);
        libraryService.addBookByName(library1.getNameLibrary(), books);
        System.out.println(Arrays.toString(libraryService.getAllLibrary()));
        System.out.println("__________________________________________________");
        System.out.println("Поиск Person в базе Library...");
        while(true){
            try{
                System.out.println("Ввведите имя для поиска: ");
                libraryService.findPersonByName(new Scanner(System.in).nextLine());
                break; //выход из цикла после успешного нахождения person
            }catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Функции: ");
        libraryService.functionBook();
    }
}
