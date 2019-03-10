package com.codefactory.classmanagement.student.dao;

import com.codefactory.classmanagement.student.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {


}