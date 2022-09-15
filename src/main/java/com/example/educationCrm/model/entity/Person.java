package com.example.educationCrm.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {
    private String name;

    private String surname;

    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
}
