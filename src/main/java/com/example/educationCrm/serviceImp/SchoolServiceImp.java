package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.service.SchoolService;
import com.example.educationCrm.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImp implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ModelMapperUtils modelMapperUtils;


    @Transactional
    @Override
    public void save(String name) {
        School school = new School(name); //Obje oluşurken name'i setleyerek bize getiriyor.
        this.schoolRepository.save(school);
    }


    @Transactional
    @Override
    public void deleteSchool(Long id) {
        this.schoolRepository.deleteById(id);

    }

    @Transactional
    @Override
    public void addListSchool(List<SchoolDTO> schoolDTOList) {
        List<School> schoolList = new ArrayList<>();
        for (SchoolDTO schoolDTO : schoolDTOList){
            School school = new School();
            school.setName(schoolDTO.getName());
            schoolList.add(school);
        }
        this.schoolRepository.saveAll(schoolList);
    }

    @Override
    public void updateSchool(SchoolDTO schoolDTO) {
        Optional<School> optionalSchool = this.schoolRepository.findById(schoolDTO.getId());
        if(optionalSchool.isPresent()){
            //içinde data varmı? bunu yapmazsan null check yapman lazım
            //önerilmez.
            School school = optionalSchool.get(); // data var. Yoksa isPresent içine girmez!!
            //update yapabilmesi için isPresent=true olmalı zaten.
            school.setName(school.getName());
            this.schoolRepository.save(school);
        }
    }

    @Override
    @Transactional
    public List<SchoolDTO> getAllSchool() {
        return this.modelMapperUtils.mapAll(
                (List<School>) this.schoolRepository.findAll(),SchoolDTO.class);

    }


}
