package com.codefactory.classmanagement.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codefactory.classmanagement.student.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {


}