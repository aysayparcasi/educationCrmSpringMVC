package com.example.educationCrm.repository;

import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    StudentInformationDTO getStudentById(Long id);

    List<Student> findStudentByLessonsId(Long lessonId);


}
