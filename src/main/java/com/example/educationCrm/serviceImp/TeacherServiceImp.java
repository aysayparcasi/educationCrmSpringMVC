package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.TeacherDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.repository.TeacherRepository;
import com.example.educationCrm.service.TeacherService;
import com.example.educationCrm.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapperUtils modelMapperUtils;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    @Transactional
    public void save(TeacherDTO teacherDTO) {
        Teacher teacher =
        this.modelMapperUtils.convertToModel(teacherDTO,Teacher.class);
       School school =
               this.schoolRepository.findById(teacherDTO.getSchool_id()).orElse(null);

        Lesson lesson=
                this.lessonRepository.findById(teacherDTO.getLesson_id()).orElse(null);

        teacher.setLesson(lesson);
        teacher.setSchool(school);
        this.teacherRepository.save(teacher);

    }

    @Override
    @Transactional
    public void update(TeacherDTO teacherDTO) {
        Optional<Teacher> teacherOptional = this.teacherRepository.findById(teacherDTO.getId());
        if (teacherOptional.isPresent()){
            Teacher teacher = teacherOptional.get();
            // teacher = modelMapperUtils.convertToModel(teacherDTO,Teacher.class);
            teacher.setBirthDate(teacher.getBirthDate());
            teacher.setName(teacher.getName());
            teacher.setSurname(teacher.getSurname());
            teacher.setCreateDate(teacher.getCreateDate());
            School school =
                    this.schoolRepository.findById(teacherDTO.getSchool_id()).orElse(null);

            Lesson lesson=
                    this.lessonRepository.findById(teacherDTO.getLesson_id()).orElse(null);

            teacher.setLesson(lesson);
            teacher.setSchool(school);
            this.teacherRepository.save(teacher);


        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.teacherRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<TeacherDTO> findAll() {
        return this.modelMapperUtils.mapAll(
                this.teacherRepository.findAll(),TeacherDTO.class);
    }
}
