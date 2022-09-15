package com.example.educationCrm.model.entity;

import com.example.educationCrm.model.dto.StudentDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Student extends Person{

    private String number;
    @ManyToOne
    private School school;
    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;
    @ManyToMany
    private List<Lesson> lessons;
    @ManyToOne //(cascade = CascadeType.REMOVE) //Bağlı olduğu ilişkiyi yönetmeyi sağlıyor.
    //Remove : Student silinirse burdaki ilişkiyi silerim artı ilişkili olduğunu da silerim
    private StudentLevel studentLevel;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    public Student() {
    }

    public Student(StudentDTO studentDTO){
        this.number= studentDTO.getNumber();

    }



    public void addLesson(Lesson lesson1) {
        this.lessons.add(lesson1);
        lesson1.getStudents().add(this);
    }


}
