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


@Entity
@Table(name = "student_m")
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


    // public void addAddress(Address add) {

    //     if(address == null) {
    //         address = new HashSet<>();
    //     }
    //     add.setStudent(this);

    //     address.add(add);
    // }

    // public void addContact(Contact contact) {

    //     if(contacts == null) {
    //         contacts = new HashSet<>();
    //     }

    //     contact.setStudent(this);

    //     contacts.add(contact);
    // }
    


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



    public Set<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Address> getAddress() {
        return this.address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
   




    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", studentName='" + getStudentName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", contacts='" + getContacts() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

   




    
}
   