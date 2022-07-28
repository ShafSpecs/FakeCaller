package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;

import java.util.List;

public interface iContactService {
    Contact addNewContact(Contact contact);
    List<Contact> getAllContacts();
}
