package com.codefactory.classmanagement.student.daoimpl;




import com.codefactory.classmanagement.student.dao.StudentDao;
import com.codefactory.classmanagement.student.model.Student;
import org.springframework.stereotype.Repository;

@Repository("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao {

   

    @Override
    public Student saveStudent(Student student) {
        
        
         return student;
    }


   

   

    

}