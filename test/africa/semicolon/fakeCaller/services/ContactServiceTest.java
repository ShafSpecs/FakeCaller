package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertNotEquals(0, newContact.getId());
    }

    @Test
    public void contactRepoSizeDecreasedAfterDeletingContact(){
        Contact newContact = new Contact();

        newContact.setFirstName("Amiajigi");
        newContact.setLastName("Loser");
        newContact.setPhoneNumber("090-Get_Lost");
        newContact.setEmail("ritual@nigeria.buhari");

        user.getContacts().add(newContact);

        service.addNewContact(newContact);
        service.deleteContact(newContact);

        assertEquals(0, service.getAllContacts().size());
    }

    @Test
    public void canGetContactThroughPhoneNumber() {
        Contact newContact = new Contact();

        newContact.setFirstName("Amiajigi");
        newContact.setLastName("Loser");
        newContact.setPhoneNumber("090-Get_Lost");
        newContact.setEmail("ritual@nigeria.buhari");

        service.addNewContact(newContact);

        assertEquals("Loser", service.findContactByNumber("090-Get_Lost").get(0).getLastName());
    }

    @Test
    public void contactCanBeEdited(){
        Contact newContact = new Contact();

        newContact.setFirstName("Amiajigi");
        newContact.setLastName("Loser");
        newContact.setPhoneNumber("090-Get_Lost");
        newContact.setEmail("ritual@nigeria.buhari");

        service.addNewContact(newContact);

        newContact.setPhoneNumber("99");

        service.editContact(newContact);

        assertEquals(1, service.getAllContacts().size());
        assertEquals("99", service.findContactByNumber("99").get(0).getPhoneNumber());
    }
}
