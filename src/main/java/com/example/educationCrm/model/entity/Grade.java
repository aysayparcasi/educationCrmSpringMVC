package com.example.educationCrm.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Grade extends BaseEntity {

    private Double grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Teacher teacher;

}
