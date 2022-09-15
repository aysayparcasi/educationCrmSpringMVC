package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentLevelDTO;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.StudentLevel;
import com.example.educationCrm.repository.StudentLevelRepository;
import com.example.educationCrm.service.StudentLevelService;
import com.example.educationCrm.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentLevelServiceImp implements StudentLevelService {
    @Autowired
    private StudentLevelRepository studentLevelRepository;

    @Autowired
    private ModelMapperUtils modelMapperUtils;


    @Transactional
    @Override
    public void save(String name) {
        StudentLevel studentLevel = new StudentLevel();
        studentLevel.setName(name);
        this.studentLevelRepository.save(studentLevel);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.studentLevelRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<StudentLevelDTO> getStudentLevels() {
        return this.modelMapperUtils.mapAll(
                (List<StudentLevel>) this.studentLevelRepository.findAll(), StudentLevelDTO.class);
    }

    @Transactional
    @Override
    public void updateStudent(StudentLevelDTO studentLevelDTO) {
        Optional<StudentLevel> optionalStudentLevel =
                this.studentLevelRepository.findById(studentLevelDTO.getId());
        if (optionalStudentLevel.isPresent())
        {
            StudentLevel studentLevel= optionalStudentLevel.get();
            studentLevel.setName(studentLevel.getName());
            this.studentLevelRepository.save(studentLevel);
        }
    }

}
