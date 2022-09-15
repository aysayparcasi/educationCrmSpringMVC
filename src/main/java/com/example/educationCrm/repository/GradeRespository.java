package com.example.educationCrm.repository;

import com.example.educationCrm.model.dto.GradeInformationDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface GradeRespository extends JpaRepository<Grade,Long> {
    GradeInformationDTO getGradeById(Long id);
}
