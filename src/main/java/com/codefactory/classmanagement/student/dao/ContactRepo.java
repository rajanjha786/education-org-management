package com.codefactory.classmanagement.student.dao;

import com.codefactory.classmanagement.student.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {

    

}