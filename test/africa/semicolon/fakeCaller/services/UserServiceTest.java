package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.Exceptions.UserExistsException;
import africa.semicolon.fakeCaller.dtos.Requests.CreateContactRequest;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    iUserService service = new UserService();

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
        service.register(request);
        //i try to register

        //assert
        //repository size is one
        assertEquals(1, service.getNumberOfUsers());
    }

    @Test
    public void duplicateEmailThrowsException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oma@gmail.com");
        request.setFirstName("oma");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        service.register(request);


        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setEmail("deborah@gmail.com");
        request2.setFirstName("deborah");
        request2.setPhoneNumber("08070374568");
        request2.setUserName("debby");
        request2.setPassword("password2");
        service.register(request2);

        assertThrows(UserExistsException.class, () -> service.register(request));

        assertEquals(2, service.getNumberOfUsers());
        assertThrows(UserExistsException.class, () -> service.register(request2));
    }

    @Test
    public void contactUserCanBeAdded() {
        iUserService userService = new UserService();

        RegisterUserRequest req = new RegisterUserRequest();
        req.setEmail("jennifer@gmail.com");
        req.setLastName("williams");
        req.setFirstName("omotola");
        req.setPassword("pinkButterfly");
        req.setPhoneNumber("09078659456");

        userService.register(req);

        CreateContactRequest addContact = new CreateContactRequest();
        addContact.setUserEmail("you@g.com");
        addContact.setLastName("Blezzing");
        addContact.setFirstName("Disguise");
        addContact.setPhoneNumber("02975654461");
        addContact.setEmail("ch@hh.com");

        userService.createContact(addContact);

        assertEquals(1, userService.getUserContacts("jennifer@gmail.com").size());
    }
}
