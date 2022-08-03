package africa.semicolon.fakeCaller.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    private List<Contact> contacts = new ArrayList<>();
}