package java_19.service.impl;
import java_19.models.User;
import java_19.service.UserService;

import java.util.Scanner;

public class UserServiceImpl implements UserService {
    User[] userArr = new User[10];
    int userCount;
    public void addUser(){
        User user1 = new User("A.A", "+996700000000", "a@gmail.com", "a123A");
        User user2 = new User("B.B", "+996700000001", "b@gmail.com", "b123B");
        userArr[userCount++] = user1;
        userArr[userCount++] = user2;
        for (int i = 0; i < userCount; i++) {
            System.out.println(userArr[i]);
        }
    }
    @Override
    public void login() {
        System.out.println("Welcome to Java-19");
        System.out.println("Write your gmail and password to log in to Website");
        System.out.println();
        System.out.println("Write your gmail");
        String gmail = new Scanner(System.in).nextLine();
        System.out.println("Write your password");
        String pass = new Scanner(System.in).nextLine();
        //проверка
        boolean isblock = false;
        for(int i=0; i<userCount; i++){
            if(userArr[i].getGmail().equals(gmail) && userArr[i].getPassword().equals(pass)){
                isblock = true;
                System.out.println("Welcome!");
            }
        }
        if(!isblock){
            throw new RuntimeException("Gmail or Pass is wrong! Try again!");
        }
    }
    @Override
    public void register() {
        while (true) {
            try {
                Scanner scInt = new Scanner(System.in);
                Scanner scStr = new Scanner(System.in);
                System.out.print("Write user name: ");
                String userName = scStr.nextLine();
                for (int i = 0; i < userCount; i++) {
                    if (userArr[i].getUserName().contains(userName)) {
                        throw new RuntimeException("Такое имя уже существует. Напишите другое");
                    }
                }
                System.out.print("\nWrite user phone number: ");
                String phoneNumber = scStr.nextLine();
                if (phoneNumber.length() != 13) {
                    throw new RuntimeException("Номер должен состоять из 13 чисел!");
                } else if (!phoneNumber.startsWith("+996")) {
                    throw new RuntimeException("Номер должен начаться с +996!");
                }
                System.out.print("\nWrite user gmail: ");
                String userGmail = scStr.nextLine();
                if (!userGmail.contains("@")) {
                    throw new RuntimeException("Вы забыли '@' в gmail!");
                }
                System.out.print("\nWrite user password: ");
                String userPass = scStr.nextLine();
                User user = new User(userName, phoneNumber, userGmail, userPass);
                userArr[userCount++] = user; //сохраняем данные
                System.out.println("Successful registration!");
                for (int i = 0; i < userCount; i++) {
                    System.out.println(userArr[i]);
                }
                break; //при успешной регистрации
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
