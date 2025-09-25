package com.wms.contactbook.controller;

import com.wms.contactbook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wms.contactbook.service.ContactService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class ContactBookController {

    private ContactService contactService;

   @Autowired
    public ContactBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping( "/contacts/{id}")
    public Contact getContact( @PathVariable BigInteger id ) {
        Optional<Contact> contact = contactService.getContact(id);
        if( contact.isPresent()) {
            return contact.get();
        }
        return null;
    }

    @GetMapping("/contacts")
    public List<Contact> getContactList() {
       return contactService.getContactList();
    }

    @PostMapping( "/contacts")
    public void addContact( @RequestBody Contact newContact ) {
       contactService.saveContact(newContact);
    }

    @PutMapping("/contacts/{id}")
    public void updateContact( @PathVariable BigInteger id, @RequestBody Contact newContact ) {
       contactService.updateContact(id, newContact);
    }

    @DeleteMapping ("/contacts/{id}")
    public void deleteContact( @PathVariable BigInteger id ) {
       contactService.deleteContactById(id);
    }

    @PatchMapping ("/contacts/{id}")
    public void updateContact( @RequestBody Contact newContact , @PathVariable BigInteger id ) {
       contactService.patchContact( newContact, id );
    }
}
