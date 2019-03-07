package com.codefactory.classmanagement.student.model;

import java.io.Serializable;

public class Student implements Serializable{

    
    private String id;

    
    private String studentName;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", studentName='" + getStudentName() + "'" +
            "}";
    }



}
   