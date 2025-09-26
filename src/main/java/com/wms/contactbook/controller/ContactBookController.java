package com.wms.contactbook.controller;

import com.wms.contactbook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wms.contactbook.service.ContactService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class ContactBookController {

    private final ContactService contactService;

   @Autowired
    public ContactBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String hello() {
        return "Contact Book";
    }

    @GetMapping( "/contacts/{id}")
    public ResponseEntity<Optional<Contact>> getContact(@PathVariable BigInteger id ) {
        Optional<Contact> contact = contactService.getContact(id);
        if(contact.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns 200 OK if the item exists
        }
        return new ResponseEntity<>(contact, HttpStatus.OK); // Returns 200 OK if the item exists

    }

    @GetMapping("/contacts")
    public List<Contact> getContactList() {
       return contactService.getContactList();
    }

    @PostMapping( "/contacts")
    public ResponseEntity<Contact> addContact( @RequestBody Contact newContact ) {
       Contact contact = contactService.saveContact(newContact);
       return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact( @PathVariable BigInteger id, @RequestBody Contact newContact ) {
       Optional<Contact> contact = contactService.updateContact(id, newContact);
        return contact.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping ("/contacts/{id}")
    public ResponseEntity<Contact> deleteContact( @PathVariable BigInteger id ) {
       Optional<Contact> contact = contactService.deleteContactById(id);
        return contact.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PatchMapping ("/contacts/{id}")
    public ResponseEntity<Contact> updateContact( @RequestBody Contact newContact , @PathVariable BigInteger id ) {
       Optional<Contact> contact = contactService.patchContact( newContact, id );
        return contact.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
