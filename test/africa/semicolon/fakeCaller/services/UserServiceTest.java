package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.Exceptions.UserExistsException;
import africa.semicolon.fakeCaller.data.repositories.UserRepository;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.DeleteContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private iUserService userService;

    @BeforeEach
    public void instantiateUserService() {
        userService = new UserService(new UserRepository(), new ContactService());
    }

    @Test
    public void registerTest() {
        //given
        //there is a request from
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oma@gmail.com");
        request.setFirstName("oma");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        //when
        userService.register(request);
        //i try to register

        //assert
        //repository size is one
        assertEquals(1, userService.getNumberOfUsers());
    }

    @Test
    public void duplicateEmailThrowsException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oma@gmail.com");
        request.setFirstName("oma");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        userService.register(request);


        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setEmail("deborah@gmail.com");
        request2.setFirstName("deborah");
        request2.setPhoneNumber("08070374568");
        request2.setUserName("debby");
        request2.setPassword("password2");
        userService.register(request2);

        assertThrows(UserExistsException.class, () -> userService.register(request));

        assertEquals(2, userService.getNumberOfUsers());
        assertThrows(UserExistsException.class, () -> userService.register(request2));
    }

    @Test
    public void contactUserCanBeAdded() {
        RegisterUserRequest req = new RegisterUserRequest();
        req.setEmail("jennifer@gmail.com");
        req.setLastName("williams");
        req.setFirstName("omotola");
        req.setPassword("pinkButterfly");
        req.setPhoneNumber("09078659456");

        userService.register(req);

        CreateContactRequest addContact = new CreateContactRequest();
        addContact.setUserEmail("jennifer@gmail.com");
        addContact.setLastName("Blezzing");
        addContact.setFirstName("Disguise");
        addContact.setPhoneNumber("02975654461");
        addContact.setEmail("ch@hh.com");

        userService.createContact(addContact);

        assertEquals(1, userService.getUserContacts("jennifer@gmail.com").size());
    }

    @Test
    public void contactCanBeDeleted(){
        RegisterUserRequest req = new RegisterUserRequest();
        req.setEmail("jennifer@gmail.com");
        req.setLastName("williams");
        req.setFirstName("omotola");
        req.setPassword("pinkButterfly");
        req.setPhoneNumber("09078659456");

        CreateContactRequest addContact = new CreateContactRequest();
        addContact.setUserEmail("jennifer@gmail.com");
        addContact.setLastName("Blezzing");
        addContact.setFirstName("Disguise");
        addContact.setPhoneNumber("02975654461");
        addContact.setEmail("ch@hh.com");

        userService.register(req);
        userService.createContact(addContact);

        assertEquals(1, userService.getUserContacts("jennifer@gmail.com").size());

        DeleteContactRequest res = new DeleteContactRequest();
        res.setContactNumber("02975654461");
        res.setUserEmail("jennifer@gmail.com");

        userService.deleteUserContact(res);

        assertEquals(0, userService.getUserContacts("jennifer@gmail.com").size());
    }
}
