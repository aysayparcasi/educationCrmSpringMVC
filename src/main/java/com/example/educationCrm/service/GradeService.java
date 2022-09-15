package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.*;

import java.text.ParseException;
import java.util.List;

public interface GradeService {
    GradeInformationDTO getGradeById(Long id);

    public void addListGrades(List<GradeDTO> gradeDTOList);

    public void updateGrade(GradeDTO gradeDTO);

    public void deleteGrade(Long id);

    public void save(GradeDTO gradeDTO) throws ParseException;
}
