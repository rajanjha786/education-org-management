package com.codefactory.classmanagement.student.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "student_m")
public class Student implements Serializable{

    
    @Id
    @GeneratedValue(generator = "student_seq_generator")
    @SequenceGenerator(
            name = "student_seq_generator",
            sequenceName = "student_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name = "name")
    private String studentName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mothername")
    private String motherName;


    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Column(name = "fathername")
    private String fatherName;



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



   


    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", studentName='" + getStudentName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", motherName='" + getMotherName() + "'" +
            "}";
    }




    
}
   