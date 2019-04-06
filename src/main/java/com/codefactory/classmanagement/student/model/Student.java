package com.codefactory.classmanagement.student.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.codefactory.classmanagement.util.model.AuditModel;

import lombok.Data;


@Entity
@Table(name = "student_m")
@Data
public class Student extends AuditModel implements Serializable {

    
    @Id
    @GeneratedValue(generator = "student_seq_generator")
    @SequenceGenerator(
            name = "student_seq_generator",
            sequenceName = "student_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    @Column(name = "studentid")
    private Long id;

    @Column(name = "name")
    private String studentName;

    @Column(name = "lastname")
    private String lastName;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, 
    orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER ,
    orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Address> address;


   
    
}
   