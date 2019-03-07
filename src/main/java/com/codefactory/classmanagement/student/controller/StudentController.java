package com.codefactory.classmanagement.student.controller;


import com.codefactory.classmanagement.student.model.Student;
import com.codefactory.classmanagement.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController("StudentController")
public class StudentController {


    @Autowired
    private StudentService studentService;


    private static final Logger logger = LogManager.getLogger(StudentController.class);

    

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        
        return "Welcome Kiran";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

        logger.debug("The request body is: "+student.toString());
        logger.info("The request body is: "+student.toString());
        logger.warn("The request body is: "+student.toString());
        logger.error("The request body is: "+student.toString());
      
        return new ResponseEntity<>(student,HttpStatus.OK);

    }




}