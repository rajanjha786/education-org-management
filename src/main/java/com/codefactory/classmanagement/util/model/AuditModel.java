
package com.codefactory.classmanagement.util.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(
      value = {"createdAt", "updatedAt","createdBy","updatedBy"},
      allowGetters = false,
      allowSetters = true
)

public abstract class AuditModel implements Serializable{

   
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;


    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}