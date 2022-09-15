package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    public void save(TeacherDTO teacherDTO);
    public void update(TeacherDTO teacherDTO);
    public void delete(Long id);
    public List<TeacherDTO> findAll();
}
