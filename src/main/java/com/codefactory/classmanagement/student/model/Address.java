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


@Entity(name = "ForeignKeyAssoAddStu")
@Table(name = "student_address")
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


    public Address() {}

    @Column(name = "iscorrespondence")
    private Short nIsPrimary;


    public Short getNIsPrimary() {
        return this.nIsPrimary;
    }

    public void setNIsPrimary(Short nIsPrimary) {
        this.nIsPrimary = nIsPrimary;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine() {
        return this.addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

   

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", addressLine='" + getAddressLine() + "'" +
            ", student='" + getStudent() + "'" +
            ", nIsPrimary='" + getNIsPrimary() + "'" +
            "}";
    }



    
}