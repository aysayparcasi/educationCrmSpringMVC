package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson,Long> {

    List<Lesson> findLessonsByStudentsId(Long studentsId);
}
