package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.DeleteContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.EditContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface iUserService {
    RegisterUserResponse register(RegisterUserRequest request);
    CreateContactResponse createContact(CreateContactRequest request);
    EditContactResponse editContact(EditContactRequest request);
    DeleteContactResponse deleteUserContact(DeleteContactRequest request);
    int getNumberOfUsers();
    List<GetAllContactsResponse> getUserContacts(String userEmail);
}