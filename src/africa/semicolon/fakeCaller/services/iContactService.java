package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;

import java.util.List;

public interface iContactService {
    Contact addNewContact(Contact contact);
    void deleteContact(Contact contact);
    Contact editContact(Contact contact);
    List<Contact> findContactByNumber(String number);
    List<Contact> findContactByFirstName(String name);
    List<Contact> getAllContacts();
}
