package java_19;

import java_19.service.UserService;
import java_19.service.impl.UserServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.addUser();
        userService.register();
        //если register успешен, переходим к login
        while (true){
            try{
                userService.login();
                break; //выход при из цикла успешном login
            }catch (RuntimeException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}