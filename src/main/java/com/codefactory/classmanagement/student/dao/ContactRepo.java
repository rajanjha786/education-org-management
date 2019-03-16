package com.codefactory.classmanagement.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codefactory.classmanagement.student.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {

    

}