package com.example.educationCrm.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@Entity
public class Teacher extends Person {

    @ManyToMany
    private List<Student> students;
    @ManyToOne
    private School school;
    @ManyToOne
    private Lesson lesson;
}
