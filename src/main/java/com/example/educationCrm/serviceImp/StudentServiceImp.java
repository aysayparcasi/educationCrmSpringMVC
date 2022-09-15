package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.StudentLevel;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.repository.StudentLevelRepository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StudentServiceImp implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentLevelRepository studentLevelRepository;

    private final SimpleDateFormat formatter =
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    //String to Date convert


    @Transactional
    @Override
    public void save(StudentDTO studentDTO) throws ParseException {
        Student student = new Student();
        student.setBirthDate((studentDTO.getBirthDate()));
        student.setNumber(studentDTO.getNumber());
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setCreateDate(new Date());

        StudentLevel studentLevel = this.studentLevelRepository
                .findById(studentDTO.getStudentLevelId()).orElse(null);


        School school =
                this.schoolRepository.findById(studentDTO.getSchoolId()).orElse(null);

        student.setSchool(school);
        student.setStudentLevel(studentLevel);

        this.studentRepository.save(student);


    }

    @Transactional(readOnly = true)
    @Override
    public StudentInformationDTO getNameSurnameById(Long id) {
        return this.studentRepository.getStudentById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public void addStudentList(List<StudentDTO> studentDTOList) {
        List<Student> studentList = new ArrayList<>();
        for (StudentDTO studentDTO: studentDTOList){
            Student student = new Student();
            student.setName(studentDTO.getName());
            student.setSurname(studentDTO.getSurname());
            student.setNumber(studentDTO.getNumber());
            studentList.add(student);
        }
        this.studentRepository.saveAll(studentList);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Optional<Student> studentOptional =
                this.studentRepository.findById(studentDTO.getId());
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setNumber(studentDTO.getNumber());
            student.setName(studentDTO.getName());
            student.setSurname(studentDTO.getSurname());
            this.studentRepository.save(student);
        }
    }


}
