package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;
import africa.semicolon.fakeCaller.data.repositories.ContactRepository;

import java.util.List;

public class ContactService implements iContactService {
    private ContactRepository repo;

    public ContactService () {
        this.repo = new ContactRepository();
    }

    public ContactService (ContactRepository repo) {
        this.repo = repo;
    }

    @Override
    public Contact addNewContact(Contact contact) {
        repo.save(contact);
        return contact;
    }

    @Override
    public void deleteContact(Contact contact) {
        repo.delete(contact);
    }

    @Override
    public Contact editContact(Contact contact) {
        Contact editedContact = repo.findById(contact.getId());

        editedContact.setFirstName(contact.getFirstName());
        editedContact.setLastName(contact.getLastName());
        editedContact.setEmail(contact.getEmail());
        editedContact.setPhoneNumber(contact.getPhoneNumber());

        repo.save(editedContact);

        return editedContact;
    }

    @Override
    public List<Contact> findContactByNumber(String number) {
        return repo.findByNumber(number);
    }

    @Override
    public List<Contact> findContactByFirstName(String name) {
        return repo.findByFirstName(name);
    }

    @Override
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }
}
