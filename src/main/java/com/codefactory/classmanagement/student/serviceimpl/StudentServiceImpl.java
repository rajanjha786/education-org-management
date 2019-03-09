package com.codefactory.classmanagement.student.serviceimpl;

import com.codefactory.classmanagement.student.dao.StudentDao;
import com.codefactory.classmanagement.student.dao.StudentRepo;
import com.codefactory.classmanagement.student.model.Student;
import com.codefactory.classmanagement.student.service.StudentService;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("StudentServiceImpl")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private Logger logger;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Student saveStudent(Student student) throws Exception {

        student = studentRepo.save(student);
       
        student = studentRepo.findById(student.getId()).orElse(null);
       
       
        return student;
    }

}