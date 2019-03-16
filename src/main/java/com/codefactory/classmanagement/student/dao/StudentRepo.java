package com.codefactory.classmanagement.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codefactory.classmanagement.student.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {


}