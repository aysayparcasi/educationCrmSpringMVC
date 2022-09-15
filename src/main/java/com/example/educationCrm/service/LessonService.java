package com.example.educationCrm.service;


import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.entity.Lesson;

import java.sql.SQLDataException;
import java.util.List;

public interface LessonService {
    public void save(String name) throws SQLDataException;

    public List<LessonDTO> getLessons();

    public void addListLesson(List<LessonDTO> lessonDTOList);

    public void updateLesson(LessonDTO lessonDTO);

    public void deleteLesson(Long id);
}
