package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.Exceptions.UserExistsException;
import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.data.models.User;
import africa.semicolon.fakeCaller.data.repositories.UserRepository;
import africa.semicolon.fakeCaller.data.repositories.iUserRepository;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.DeleteContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.EditContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.*;
import africa.semicolon.fakeCaller.utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class UserService implements iUserService {
    private final UserRepository userRepo;
    private final ContactService contactService;

    public UserService() {
        this.userRepo = new UserRepository();
        this.contactService = new ContactService();
    }

    public UserService(iUserRepository userRepository, iContactService contactService) {
        this.userRepo = (UserRepository) userRepository;
        this.contactService = (ContactService) contactService;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        validate(request.getEmail());

        User user = new User();
        Mapper.map(request, user);

        userRepo.save(user);

        RegisterUserResponse res = new RegisterUserResponse();
        res.setMessage(String.format("%s successfully registered", request.getEmail()));

        return res;
    }

    private void validate(String emailAddress) {
        User savedUser = userRepo.findByEmail(emailAddress);
        if (savedUser != null) throw new UserExistsException(emailAddress + " already exists!");
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

        CreateContactResponse res = new CreateContactResponse();
        res.setMessage(String.format("%s %s successfully added", request.getFirstName(), request.getLastName()));

        return res;
    }

    @Override
    public EditContactResponse editContact(EditContactRequest request) {
        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepo.count();
    }

    @Override
    public List<GetAllContactsResponse> getUserContacts(String userEmail) {
        User validUser = userRepo.findByEmail(userEmail);
        List<Contact> allUserContacts = validUser.getContacts();

        List<GetAllContactsResponse> res = new ArrayList<>();

        allUserContacts.forEach(contact -> {
            GetAllContactsResponse response = new GetAllContactsResponse();

            response.setId(contact.getId());
            response.setFirstName(contact.getFirstName());
            response.setLastName(contact.getLastName());

            res.add(response);
        });

        return res;
    }

    @Override
    public DeleteContactResponse deleteUserContact(DeleteContactRequest request) {
        User currentUser = userRepo.findByEmail(request.getUserEmail());
        Contact toBeDeleted = contactService.findContactByNumber(request.getContactNumber()).get(0);

        List<Contact> userContacts = currentUser.getContacts();

        contactService.deleteContact(toBeDeleted);

        userContacts.remove(toBeDeleted);

        return null;
    }
}