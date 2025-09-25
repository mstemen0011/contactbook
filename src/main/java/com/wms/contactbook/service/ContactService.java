package com.wms.contactbook.service;

import com.wms.contactbook.model.Contact;
import com.wms.contactbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {

    }

    public List<Contact> getContactList() {
        return this.contactRepository.findAll();
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public void deleteContactById(BigInteger id) {
        Optional<Contact> contactToDelete = contactRepository.findById(id);
        contactToDelete.ifPresent(contact -> contactRepository.delete(contact));
    }

    public Optional<Contact> getContact(BigInteger id ) {
        Optional<Contact> optional = Optional.empty();
        optional = contactRepository.findById(id);

        return optional;
    }

    public void saveContact( Contact contact ) {
        contactRepository.save(contact);
    }

    public void updateContact(BigInteger id, Contact newContact) {
        Optional<Contact> optional = contactRepository.findById(id);
        if(optional.isPresent()) {
            Contact contact = optional.get();
            contact.setFirstName(newContact.getFirstName());
            contact.setLastName(newContact.getLastName());
            contact.setEmail(newContact.getEmail());
            contact.setPhone(newContact.getPhone());
            contactRepository.save(contact);
        }
    }

    public void patchContact(Contact newContact, BigInteger id) {
        Optional<Contact> optional = contactRepository.findById(id);
        if(optional.isPresent()) {
            Contact contact = optional.get();
            if( newContact.getFirstName() != null && ! newContact.getFirstName().isEmpty() ) {
                contact.setFirstName(newContact.getFirstName());
            }
            if( newContact.getLastName() != null && ! newContact.getLastName().isEmpty() ) {
                contact.setLastName(newContact.getLastName());
            }
            if( newContact.getEmail() != null  && ! newContact.getEmail().isEmpty() ) {
                contact.setEmail(newContact.getEmail());
            }
            if( newContact.getPhone() != null && ! newContact.getPhone().isEmpty()) {
                contact.setPhone(newContact.getPhone());
            }
            contactRepository.save(contact);

        }
    }
}
