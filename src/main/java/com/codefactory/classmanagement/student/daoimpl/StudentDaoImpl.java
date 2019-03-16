package com.codefactory.classmanagement.student.daoimpl;




import org.springframework.stereotype.Repository;

import com.codefactory.classmanagement.student.dao.StudentDao;
import com.codefactory.classmanagement.student.model.Student;

@Repository("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao {

   

    @Override
    public Student saveStudent(Student student) {
        
        
         return student;
    }


   

   

    

}