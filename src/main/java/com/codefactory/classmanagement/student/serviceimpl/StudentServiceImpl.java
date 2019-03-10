package com.codefactory.classmanagement.student.serviceimpl;

import com.codefactory.classmanagement.student.dao.AddressRepo;
import com.codefactory.classmanagement.student.dao.ContactRepo;
import com.codefactory.classmanagement.student.dao.StudentDao;
import com.codefactory.classmanagement.student.dao.StudentRepo;
import com.codefactory.classmanagement.student.model.Address;
import com.codefactory.classmanagement.student.model.Contact;
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
    private AddressRepo addressRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private Logger logger;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Student saveStudent(Student student) throws Exception {

        student = studentRepo.save(student);
       

        for(Address a: student.getAddress())
       {
           a.setStudent(student);
           addressRepo.save(a);
       }

       for(Contact c: student.getContacts())
       {
           c.setStudent(student);
           contactRepo.save(c);
       }
       
       student = studentRepo.findById(student.getId()).orElse(null);
       
       
        return student;
    }

    @Override
    public Student getStudent(Long studentId) {
        
        return studentRepo.findById(studentId).orElse(null);
    }

    @Override
    public Address getAddress(Long studentId, Long addressId) throws Exception {
     
        if(studentRepo.existsById(studentId)) {

            return addressRepo.findById(addressId).orElseThrow(() -> new Exception("address does not exist.."));
        }
        else {
            throw new Exception("Student Does not Exist....");
        }
    }

}