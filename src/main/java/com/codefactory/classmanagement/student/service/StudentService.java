package com.codefactory.classmanagement.student.service;

import com.codefactory.classmanagement.student.model.Address;
import com.codefactory.classmanagement.student.model.Student;

public interface StudentService {

	Student saveStudent(Student student) throws Exception ;

	Student getStudent(Long studentId);

	Address getAddress(Long studentId, Long addressId) throws Exception;

	

	
    
}