package com.example.educationCrm.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Lesson extends BaseEntity{
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(mappedBy = "lesson")
    //neden mappedBy = lesson oldu?
    //    private Lesson lesson; -- Teacher classında bu şekilde tanımladığın için.
    //Lesson lesson'daki "lesson" ilişkili classtaki mappedBy'a yazılmalıdır.
    private List<Teacher> teachers;
    @ManyToMany(mappedBy = "lessons")
    //@JoinTable(name = "studet_lessons")
    //yazmasanda olur ama kodunun okunabilirliğini artırmak için yazmalısın.
    private List<Student> students;


    public Lesson() {
    }

    public Lesson(String name) {
        this.name = name;
    }
}
