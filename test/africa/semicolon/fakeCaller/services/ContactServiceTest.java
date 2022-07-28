package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.data.models.User;
import africa.semicolon.fakeCaller.data.repositories.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceTest {
    private ContactService service;
    private User user;

    @BeforeEach
    public void initializationAsUsual(){
        service = new ContactService();
        user = new User();
    }

    @Test
    public void contactRepoSizeIncreasesAfterAddingANewContact() {
        Contact newContact = new Contact();

        newContact.setFirstName("Amiajigi");
        newContact.setLastName("Loser");
        newContact.setPhoneNumber("090-Get_Lost");
        newContact.setEmail("ritual@nigeria.buhari");

        user.getContacts().add(newContact);

        service.addNewContact(newContact);

        assertEquals(1, service.getAllContacts().size());
    }
}
