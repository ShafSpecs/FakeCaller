package africa.semicolon.fakeCaller.controllers;

import africa.semicolon.fakeCaller.Exceptions.UserExistsException;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.GetAllContactsResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;
import africa.semicolon.fakeCaller.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements iUserController {
    private UserService service = new UserService();

    @Override
    @CrossOrigin("http://127.0.0.1:5500/")
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            RegisterUserResponse res = service.register(request);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (UserExistsException err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @CrossOrigin("http://127.0.0.1:5500/")
    @PatchMapping("/user")
    public CreateContactResponse addContact(@RequestBody CreateContactRequest request) {
        return service.createContact(request);
    }

    @Override
    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/user/{userEmail}")
    public List<GetAllContactsResponse> findUserContacts(@PathVariable String userEmail) {
        return service.getUserContacts(userEmail);
    }
}