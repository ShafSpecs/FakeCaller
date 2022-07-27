package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.data.models.Contact;

public class ContactService implements iContactService {
    @Override
    public Contact addNewContact(Contact contact) {
        return contact;
    }
}
