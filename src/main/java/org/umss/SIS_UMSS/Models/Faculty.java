package org.umss.SIS_UMSS.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Faculty {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(updatable = false, nullable = false)
    private String uuid;
    private String name;
    private String code;
    @ManyToOne(fetch = FetchType.LAZY)
    private University university;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    public Faculty(Integer id, String uuid, String name, String code, Date createdDate) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.createdDate = createdDate;
    }

    public Faculty() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @PrePersist
    public void initializeUuid(){
        this.setUuid(UUID.randomUUID().toString());
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
