package task2.models;

import task2.enums.Gender;

import java.time.LocalDate;

public class Person {
    private Long id;
    private String namePerson;
    private LocalDate dateOfBirth;
    private Gender gender;
    public Person() {}
    public Person(Long id, String namePerson, LocalDate dateOfBirth, Gender gender) {
        this.id = id;
        this.namePerson = namePerson;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNamePerson() {
        return namePerson;
    }
    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "\nPerson{" +
                "Id: " + id +
                ", NamePerson: " + namePerson + '\'' +
                ", DateOfBirth: " + dateOfBirth +
                ", Gender: " + gender +
                '}';
    }
}
