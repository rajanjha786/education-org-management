package com.codefactory.classmanagement.student.dao;

import com.codefactory.classmanagement.student.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {

    Student findById(long id);

}