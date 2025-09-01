package task2.service.impl;

import task2.models.Person;
import task2.service.PersonService;

public class PersonServiceImpl implements PersonService {
    //todo DB-Array
    Person[] personArr = new Person[10];
    int countPerson;
    @Override
    public void addPerson(Person newPerson) {
        personArr[countPerson++] = newPerson;
        System.out.println("Data-Person is created! ");
    }
    @Override
    public Person[] getAll() {
        return personArr;
    }
    @Override
    public Person findPersonByName(String namePeron) {
        boolean isblock = false;
        for(Person p : personArr){
            if(p.getNamePerson().equals(namePeron)){
                isblock = true;
                return p;
            }
        }
        return null;
    }
    @Override
    public void updatePersonByName(String namePeron, Person newPerson) {
        Person oldPerson = findPersonByName(namePeron);
        oldPerson.setNamePerson(newPerson.getNamePerson());
        oldPerson.setDateOfBirth(newPerson.getDateOfBirth());
        oldPerson.setGender(newPerson.getGender());
        System.out.println("Data-Person is changed!");
    }

    @Override
    public void deletePersonByName(String namePerson) {
        boolean isblock = false;
        for(int i=0; i<countPerson; i++){
            if(personArr[i].getNamePerson().equals(namePerson)){
                isblock = true;
                for(int j=0; j<countPerson - 1; j++){ //сдвигаем элементы, когда удаляем по имени person
                    personArr[j] = personArr[j+1];
                }
                personArr[countPerson - 1] = null; //обнуляем последний элемент
                countPerson--; //кол-во элементов уменьшется
                System.out.println("Person deleted!");
                break;
            }
        }
        if(!isblock){
            System.out.println("Such name person not found!");
        }
    }
}
