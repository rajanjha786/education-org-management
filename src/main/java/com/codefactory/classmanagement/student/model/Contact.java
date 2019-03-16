package com.codefactory.classmanagement.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.codefactory.classmanagement.util.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ForeignKeyAssoContactStu")
@Table(name = "student_contact")
public class Contact extends AuditModel{


    public Contact(){}

    @Id
    @GeneratedValue(generator = "contact_seq_generator")
    @SequenceGenerator(
            name = "contact_seq_generator",
            sequenceName = "contact_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    @Column(name = "contactid")
    private Long id;

    @Column(name = "contactnumber",nullable = false)
    private String contactNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentid", nullable = false)
    @JsonIgnore
    private Student student;

    @Column(name = "iscorrespondence")
    private Short nIsPrimary;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    


    public Short getNIsPrimary() {
        return this.nIsPrimary;
    }

    public void setNIsPrimary(Short nIsPrimary) {
        this.nIsPrimary = nIsPrimary;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", contactNo='" + getContactNo() + "'" +
            ", student='" + getStudent() + "'" +
            ", nIsPrimary='" + getNIsPrimary() + "'" +
            "}";
    }




}