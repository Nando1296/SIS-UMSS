package org.umss.SIS_UMSS.Models;

import java.util.Date;

public class University {
    private Integer id;
    private String uuid;
    private String name;
    private String code;
    private Date createdDate;



    public University(Integer id, String uuid, String name, String code, Date createdDate) {
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.name = name;
        this.createdDate = createdDate;
    }

    public University() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
