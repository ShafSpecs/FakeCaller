package africa.semicolon.fakeCaller.controllers;

import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;

import java.util.List;

public interface iUserController {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    CreateContactResponse addContact(CreateContactRequest request);
    List<Contact> findUserContacts(String userEmail);
}
