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

import lombok.Data;

@Entity(name = "ForeignKeyAssoContactStu")
@Table(name = "student_contact")
@Data
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


    


}