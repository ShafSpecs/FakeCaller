package africa.semicolon.fakeCaller;

import africa.semicolon.fakeCaller.controllers.UserController;
import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final UserController controller = new UserController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        mainMenuPrompt();
    }

    public static String inputPrompt(String prompt){
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void mainMenuPrompt() {
        String prompt = """
                Welcome to Fake Caller:
                1 -> Create an Account
                2 -> Add contact to a user
                3 -> Find all contacts belonging to user
                
                """;

        String userInput = inputPrompt(prompt);

        switch (userInput) {
            case "1" -> createAccount();
            case "2" -> createContact();
            case "3" -> findAllContacts();
        }
    }

    private static void findAllContacts() {
//        String email = inputPrompt("Enter your user email:");
//
//        ArrayList<Contact> contacts = (ArrayList<Contact>) controller.findUserContacts(email);
//
//        contacts.forEach(contact -> System.out.printf("%s", contact.toString()));
        mainMenuPrompt();
    }

    private static void createAccount(){
        RegisterUserRequest request = new RegisterUserRequest();

        request.setFirstName(inputPrompt("Enter your first name:"));
        request.setLastName(inputPrompt("Enter your last name:"));
        request.setPhoneNumber(inputPrompt("Enter your phone number:"));
        request.setEmail(inputPrompt("Enter your email address:"));
        request.setPassword(inputPrompt("Enter your password:"));

        controller.registerUser(request);
        mainMenuPrompt();
    }

    private static void createContact(){
        CreateContactRequest request = new CreateContactRequest();

        request.setUserEmail(inputPrompt("Enter your user email:"));
        request.setFirstName(inputPrompt("Enter the contact first name:"));
        request.setLastName(inputPrompt("Enter the contact last name:"));
        request.setEmail(inputPrompt("Enter the contact email:"));
        request.setPhoneNumber(inputPrompt("Enter the phone number:"));

        controller.addContact(request);
        mainMenuPrompt();
    }
}
