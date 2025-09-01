package task2.service.impl;

import task2.enums.Booked;
import task2.enums.GenreBook;
import task2.models.Book;
import task2.models.Library;
import task2.models.Person;
import task2.service.LibraryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryService {
    Library[] libraryArr = new Library[5];
    int countLib;
    @Override
    public void addLibrary(Library newLibrary) {
        libraryArr[countLib++] = newLibrary;
        System.out.println("Data-Library created!");
    }

    @Override
    public Library[] getAllLibrary() {
        return libraryArr;
    }

    @Override
    public void addPersonByName(String libName, Person[] allPerson) {
        for(int i=0; i<countLib; i++){ //поиск библиотеки из libraryArr
            Library lib = libraryArr[i];
            if(lib != null && lib.getNameLibrary().equals(libName)) {
                Person[] oldPersons = lib.getPersons(); //получаем текущий массив
                if (oldPersons == null) {
                    oldPersons = new Person[0];
                }
                Person[] newPersons = new Person[oldPersons.length + allPerson.length]; //новый массив
            /*for(int j=0; j< oldPersons.length; j++){ //копируем старых person
                newPersons[j] = oldPersons[j];
            }*/
                System.arraycopy(oldPersons, 0, newPersons, 0, oldPersons.length); //копируем старых элементов
                System.arraycopy(allPerson, 0, newPersons, oldPersons.length, allPerson.length); //копируем новых
                lib.setPersons(newPersons); //сохраняем person в Library
                System.out.println("Persons added!");
                return;
            }
        }
    }

    @Override
    public void addBookByName(String libName, Book[] newBooks) {
        for(int i=0; i<countLib; i++){
            Library lib = libraryArr[i];
            if(lib != null && lib.getNameLibrary().equals(libName)){
                Book[] oldBooks = lib.getBooks();
                if(oldBooks == null){
                    oldBooks = new Book[0];
                }
                Book[] books = new Book[oldBooks.length + newBooks.length]; //новый массив
                System.arraycopy(oldBooks, 0, books, 0, oldBooks.length); //копируем старых элементов
                System.arraycopy(newBooks, 0, books, oldBooks.length, newBooks.length); //копируем новый массив
                lib.setBooks(books); //схраняем books в Library
                System.out.println("Books added!");
            }
        }
        System.out.println("Such Library name not found!");
    }

    @Override
    public void findPersonByName(String namePerson) {
//        while(true) {
//            try {
                boolean isblock = false;
                for (int i = 0; i < countLib; i++) {
                    Library library = libraryArr[i];
                    for (Person p : library.getPersons()) {
                        if (p.getNamePerson().equals(namePerson)) {
                            isblock = true;
                            System.out.println("Кош келиниз!");
                        }
                    }
                }
                if (!isblock) {
                    throw new RuntimeException("Табылган жок!");
                }
//            }catch (RuntimeException e){
//                System.err.println(e.getMessage());
//            }
        }

    @Override
    public void functionBook() {
        System.out.println("""
                Выберите функции: 
                1.Китеп алам;
                2.Китеп тапшырам;
                3.Китепти жылы менен издоо;
                4.Китепти жанр менен издоо.
                """);
        int command = new Scanner(System.in).nextInt();
        switch (command){
            case 1:
                while(true){
                    System.out.println("Введите название книги: ");
                    String nameBook = new Scanner(System.in).nextLine();
                    findBookByName(nameBook);
                    break;
                }

            case 2:
                    donateBook();
               break;
            case 3:
                findBookByYear();
                break;
            case 4:
                findBookByGenre();
                break;
        }

    }
    private void findBookByName(String nameBook){
        boolean isblock = false;
            try{
                for(int i=0; i<countLib; i++){
                    Library library = libraryArr[i];
                    Book[] books = library.getBooks();
                    for(Book b : books) {
                        if (b.getNameBook().equals(nameBook)) {
                            isblock = true;
                            if (b.getIsBooked().equals(Booked.ISBOOKED)) {
                                System.out.println("Мындай китеп бар. Бирок башка бироо окуп жатат!");
                            } else if (b.getIsBooked().equals(Booked.NOT_BOOKED)) {
                                System.out.println("Китеп бош!");
                            }
                        }
                    }
                }
                if(!isblock){
                    throw new RuntimeException("Мындай китеп жок!");
                }
            }catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
    }
    private void donateBook(){
        boolean isblock = false; //ищем совпадение книг по имени
        boolean isBooked = false; //бронирование книги
        while(true){
            try{
                System.out.println("Укажите название книги: ");
                String nameBook = new Scanner(System.in).nextLine();
                for(int i=0; i<countLib; i++){
                    Library library = libraryArr[i];
                    Book[] books = library.getBooks();
                    for(Book b : books){
                        if(b.getNameBook().equals(nameBook)){
                            isblock = true;
                            if(b.getIsBooked().equals(Booked.ISBOOKED)){
                                b.setIsBooked(Booked.NOT_BOOKED);
                                isBooked = true;
                                System.out.println("Книга возвращена!");
                                return;
                            } else {
                                System.out.println("Эта книга изначально не сдавалась!");
                            }
                            break;
                        }
                    }
                    if(isblock) break; //выход из цикла, если книга найдена
                }
                if(!isblock){
                    throw new RuntimeException("Such book name not found!");
                }
            }catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
        }
    }
    private void findBookByYear(){
        while (true){
            try{
                System.out.println("Введите год издания: ");
                int year = new Scanner(System.in).nextInt();
                boolean isblock = false;
                for(int i=0; i<countLib; i++){
                    Library library = libraryArr[i];
                    Book[] books = library.getBooks();
                    for(Book b : books){
                        if(b.getYearEdition().getYear() == year){
                            isblock = true;
                            System.out.println("Китеп бар!");
                        }
                    }
                    if(!isblock){
                        throw new RuntimeException("Мындай жылдагы китеп жок!");
                    }
                    break; //выход из цикла, если найдена книга
                }
                break; //выход из while если успешно
            }catch (InputMismatchException e){
                System.out.println("Вы не ввели число!");
            }
            catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
        }
    }
    private void findBookByGenre(){
        while (true){
            try {
                System.out.println("Введите жанр книги: ");
                String genre = new Scanner(System.in).nextLine();
                boolean isblock = false;
                for(int i=0; i<countLib; i++){
                    Library library = libraryArr[i];
                    Book[] books = library.getBooks();
                    for(Book b : books){
                        if(b.getGenre().equals(GenreBook.valueOf(genre))){
                            isblock = true;
                            System.out.println("Китеп бар! [ " + b.getNameBook() + " ]");
                        }
                    }
                    break; //выходим из укла, если есть совпадение
                }
                if(!isblock){
                    throw new RuntimeException("Мындай жанрдагы китеп жок!");
                }
                break; //программа останавливается если успешно найдено
            }catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
