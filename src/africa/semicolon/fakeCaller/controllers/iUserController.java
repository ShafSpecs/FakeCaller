package africa.semicolon.fakeCaller.controllers;

import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.GetAllContactsResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface iUserController {
    ResponseEntity<?> registerUser(RegisterUserRequest request);
    CreateContactResponse addContact(CreateContactRequest request);
    List<GetAllContactsResponse> findUserContacts(String userEmail);
}
