package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.Student;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    public void save(StudentDTO studentDTO) throws ParseException;

    StudentInformationDTO getNameSurnameById(Long id);

    public void deleteById(Long id);

    public void addStudentList(List<StudentDTO> studentDTOList); //benim metodum

    public void updateStudent(StudentDTO studentDTO);

    //get keywordu önemli!!
    //get ve By keyword'tür.
    //Parametre verdiğinde ById deki By olmak zorundadır. Yoksa sorguları yapamazsın.
}
