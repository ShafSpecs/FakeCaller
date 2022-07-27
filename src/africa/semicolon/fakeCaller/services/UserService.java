package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.Exceptions.UserExistsException;
import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.data.models.User;
import africa.semicolon.fakeCaller.data.repositories.UserRepository;
import africa.semicolon.fakeCaller.data.repositories.iUserRepository;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;

import java.util.List;

public class UserService implements iUserService {
    private final UserRepository userRepo;
    private final ContactService contactService;

    public UserService(iUserRepository userRepository, iContactService contactService) {
        this.userRepo = (UserRepository) userRepository;
        this.contactService = (ContactService) contactService;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        // check if email exists and throw exception

        //create a new user
        //copy fields  from request to new user
        //save new user into repository
        User savedUser = userRepo.findByEmail(request.getEmail());

        if(savedUser != null) throw new UserExistsException(request.getEmail() + " already exists!");

        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());

        userRepo.save(user);

        return null;
    }

    @Override
    public CreateContactResponse createContact(CreateContactRequest request) {
        Contact newContact = new Contact();
        newContact.setEmail(request.getEmail());
        newContact.setPhoneNumber(request.getPhoneNumber());
        newContact.setFirstName(request.getFirstName());
        newContact.setLastName(request.getLastName());

        Contact savedContact = contactService.addNewContact(newContact);

        User user = userRepo.findByEmail(request.getUserEmail());

        user.getContacts().add(savedContact);

        userRepo.save(user);

        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepo.count();
    }

    @Override
    public List<Contact> getUserContacts(String userEmail) {
        User validUser = userRepo.findByEmail(userEmail);
        return validUser.getContacts();
    }
}