package com.wms.contactbook.repository;

import com.wms.contactbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface ContactRepository extends JpaRepository<Contact, BigInteger> {
}
