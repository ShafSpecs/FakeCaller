package africa.semicolon.fakeCaller.controllers;

import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;
import africa.semicolon.fakeCaller.services.UserService;

import java.util.List;

public class UserController implements iUserController {
    private UserService service = new UserService();

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        return service.register(request);
    }

    @Override
    public CreateContactResponse addContact(CreateContactRequest request) {
        return service.createContact(request);
    }

    @Override
    public List<Contact> findUserContacts(String userEmail) {
        return service.getUserContacts(userEmail);
    }
}