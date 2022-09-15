package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.model.entity.School;

import java.util.List;

public interface SchoolService {
    public void save(String name);
    public void deleteSchool(Long id);
    public void addListSchool(List<SchoolDTO> lessonDTO);
    public void updateSchool(SchoolDTO schoolDTO);
    public List<SchoolDTO> getAllSchool();


}
