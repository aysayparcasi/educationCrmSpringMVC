package com.example.educationCrm.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class School extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "school")
    private List<Student> students;
    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    public School() { //kütüphaneler vs kullanacağı için. Ekliyoruz..
    }

    public School(String name) {
        this.name = name;
    }
}
