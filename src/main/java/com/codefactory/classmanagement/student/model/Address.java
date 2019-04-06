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


@Entity(name = "ForeignKeyAssoAddStu")
@Table(name = "student_address")
@Data
public class Address extends AuditModel{

    @Id
    @GeneratedValue(generator = "address_seq_generator")
    @SequenceGenerator(
            name = "address_seq_generator",
            sequenceName = "address_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    @Column(name = "addressid")
    private Long id;

    @Column(name = "address", nullable = false)
    private String addressLine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentid", nullable = false)
    @JsonIgnore
    private Student student;


    @Column(name = "iscorrespondence")
    private Short nIsPrimary;



    
}