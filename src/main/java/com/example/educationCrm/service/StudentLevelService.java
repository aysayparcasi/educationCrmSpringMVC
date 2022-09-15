package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentLevelDTO;

import java.util.List;

public interface StudentLevelService {
    public void save(String name);
    public void deleteById(Long id);
    public List<StudentLevelDTO> getStudentLevels();
    public void updateStudent(StudentLevelDTO studentLevelDTO);
}
