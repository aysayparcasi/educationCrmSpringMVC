package com.example.educationCrm.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student_Class")
public class StudentLevel extends BaseEntity{

    private String name;
    @OneToMany(mappedBy = "studentLevel")
    private List<Student> students;
    @ManyToMany
    private List<Teacher> teachers;

}
