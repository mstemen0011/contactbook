package service;

import model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService {

    private List<Contact> contactList;

    public ContactService() {
        contactList = new ArrayList<>();
        Contact contactOne = new Contact(1, "Test1", "TestLName1", "Test@test.com", "");
        Contact contactTwo = new Contact(2, "Test2", "TestLName2", "Test@test.com", "");
        Contact contactThree = new Contact(3, "Test3", "TestLName3", "Test@test.com", "");
        Contact contactFour = new Contact(4, "Test4", "TestLName4", "Test@test.com", "");
        Contact contactFive = new Contact(5, "Test5", "TestLName5", "Test@test.com", "");

        contactList.add(contactOne);
        contactList.add(contactTwo);
        contactList.add(contactThree);
        contactList.add(contactFour);
        contactList.add(contactFive);

    }

    public List<Contact> getContactList() {
        return contactList;



    }

    public Optional<Contact> getContact(Integer id ) {
        Optional<Contact> optional = Optional.empty();
        for( Contact contact : contactList){
            if(Objects.equals(id, contact.getId())) {
                optional = Optional.of(contact);
            }
        }
        return optional;
    }

}
