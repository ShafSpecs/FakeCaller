package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;

public interface iUserService {
    RegisterUserResponse register(RegisterUserRequest request);

    CreateContactResponse createContact(CreateContactResponse request);

    int getNumberOfUsers();
}