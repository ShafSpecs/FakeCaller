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
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }
}
