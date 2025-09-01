package task2.service;
import task2.models.Person;

public interface PersonService {
    void addPerson(Person newPerson);
    Person[] getAll();
    Person findPersonByName(String namePeron);
    void updatePersonByName(String oldPeron, Person newPerson);
    void deletePersonByName(String namePerson);
}
