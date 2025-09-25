package com.wms.contactbook.controller;

import com.wms.contactbook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wms.contactbook.service.ContactService;

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

    @GetMapping( "/contact")
    public Contact getContact( @RequestParam Integer id ) {
        Optional<Contact> contact = contactService.getContact(id);
        if( contact.isPresent()) {
            return contact.get();
        }
        return null;
    }
}
