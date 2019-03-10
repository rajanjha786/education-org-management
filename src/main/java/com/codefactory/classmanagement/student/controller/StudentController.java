package com.codefactory.classmanagement.student.controller;

import com.codefactory.classmanagement.student.model.Address;
import com.codefactory.classmanagement.student.model.Student;
import com.codefactory.classmanagement.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Logger;

@RestController("StudentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Logger logger;

    // private static final Logger logger =
    // LogManager.getLogger(StudentController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return "Welcome Kiran";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) throws Exception {

        logger.info("The Request Body is : "+ student.toString());
        student = studentService.saveStudent(student);

        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId){
        
        Student student = studentService.getStudent(studentId);

        return new ResponseEntity<>(student,HttpStatus.OK);

    }

    @RequestMapping(value = "/student/{studentId}/{addressId}", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddress(@PathVariable Long studentId,
    @PathVariable Long addressId) throws Exception {

        Address address = studentService.getAddress(studentId,addressId);

        return new ResponseEntity<>(address,HttpStatus.OK);

    }

}