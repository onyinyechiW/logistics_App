package shita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shita.dto.request.RegisterUserRequest;
import shita.dto.response.RegisteredUserResponse;
import shita.model.User;
import shita.controller.UserController;

import javax.swing.*;

@SpringBootApplication
public class Main {

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
    private static final UserController userController = new UserController();

    private static void registerNewUser(){
        String firstName = collectStringInput("Enter your first name");
        String lastName = collectStringInput("Enter your last name");
        String email = collectStringInput("Enter your email");
        String address = collectStringInput("Enter your address");
        String phoneNumber = collectStringInput("Enter your phoneNumber");

        RegisterUserRequest userRequest = new RegisterUserRequest();
        userRequest.setFirstName(firstName);
        userRequest.setLastName(lastName);
        userRequest.setAddress(address);
        userRequest.setEmail(email);
        userRequest.setPhoneNumber(phoneNumber);

        RegisteredUserResponse registeredUser = userController.registerNewUser(userRequest);
        display(String.valueOf(registeredUser));
        main();
    }

    private static void findRegisteredUser(){
        int userId = collectUserInput("Enter your id");
        User foundUser = userController.findUserById(userId);
        display(String.valueOf(foundUser));
        main();
    }

    private static int collectUserInput(String prompt) {
        return Integer.parseInt(JOptionPane.showInputDialog(prompt));
    }

    private static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static String collectStringInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}
