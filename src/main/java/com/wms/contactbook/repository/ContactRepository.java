package com.wms.contactbook.repository;

import com.wms.contactbook.model.Contact;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


public interface ContactRepository extends JpaRepository<Contact, BigInteger> {
}
