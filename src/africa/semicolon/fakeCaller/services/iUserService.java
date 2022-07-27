package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.data.models.User;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;

import java.util.List;

public interface iUserService {
    RegisterUserResponse register(RegisterUserRequest request);

    CreateContactResponse createContact(CreateContactRequest request);

    int getNumberOfUsers();

    List<Contact> getUserContacts(String userEmail);
}