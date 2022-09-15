package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.GradeDTO;
import com.example.educationCrm.model.dto.GradeInformationDTO;
import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.entity.Grade;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.repository.GradeRespository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.repository.TeacherRepository;
import com.example.educationCrm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImp implements GradeService {

    @Autowired
    private GradeRespository gradeRespository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public GradeInformationDTO getGradeById(Long id) {
        return this.gradeRespository.getGradeById(id);
    }

    @Transactional
    @Override
    public void addListGrades(List<GradeDTO> gradeDTOList) {
        List<Grade> grades = new ArrayList<>();
        for (GradeDTO gradeDTO: gradeDTOList){
            Grade grade = new Grade();
            grade.setGrade(gradeDTO.getGrade());
            grades.add(grade);
        }
        this.gradeRespository.saveAll(grades);
    }
    @Transactional
    @Override
    public void updateGrade(GradeDTO gradeDTO) {
        Optional<Grade> optionalGrade = this.gradeRespository.findById(gradeDTO.getId());
        if(optionalGrade.isPresent()){
            //içinde data varmı? bunu yapmazsan null check yapman lazım
            //önerilmez.
            Grade grade = optionalGrade.get(); // data var. Yoksa isPresent içine girmez!!
            //Obje oluştrup optionalGrade'tekini alıyoeuz.
            //update yapabilmesi için isPresent=true olmalı zaten.

            grade.setGrade(grade.getGrade());
           Student student =
                    this.studentRepository.findById(gradeDTO.getStudentId()).orElse(null);
            grade.setStudent(student); // id'nin obje karşılığını bulmak için yapıyoruz bunu

            Teacher teacher =
                    this.teacherRepository.findById(gradeDTO.getTeacherId()).orElse(null);
            grade.setTeacher(teacher);

            this.gradeRespository.save(grade);

        }

    }

    @Transactional
    @Override
    public void deleteGrade(Long id) {
        this.gradeRespository.deleteById(id);

    }


    @Transactional
    @Override
    public void save(GradeDTO gradeDTO) throws ParseException {
        Grade grade = new Grade();
        grade.setGrade(gradeDTO.getGrade());

        Student student =
                this.studentRepository.findById(gradeDTO.getStudentId()).orElse(null);
        grade.setStudent(student);
        Teacher teacher =
                this.teacherRepository.findById(gradeDTO.getTeacherId()).orElse(null);
        grade.setTeacher(teacher);
        this.gradeRespository.save(grade);
    }
}
