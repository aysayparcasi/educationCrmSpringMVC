package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.service.LessonService;
import com.example.educationCrm.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImp implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ModelMapperUtils modelMapperUtils;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(String name) throws SQLDataException {
        Lesson lesson = new Lesson(name);
        this.lessonRepository.save(lesson);
      //  throw new SQLDataException("Kayıt yapılamadı");
        //bu kod parçası lesson kaydı yapılmamasını sağlar.
    }


    @Override
    @Transactional
    public List<LessonDTO> getLessons() {
        return  this.modelMapperUtils.mapAll(
                 (List<Lesson>) this.lessonRepository.findAll(),LessonDTO.class);
    }

    @Transactional
    @Override
    public void addListLesson(List<LessonDTO> lessonDTOList) {
        List<Lesson> lessonList = new ArrayList<>();
        for (LessonDTO lessonDTO : lessonDTOList){
            Lesson lesson = new Lesson();
            lesson.setName(lessonDTO.getName());
            lessonList.add(lesson);
        }
        this.lessonRepository.saveAll(lessonList);

    }

    @Override
    @Transactional
    public void updateLesson(LessonDTO lessonDTO) {
        Optional<Lesson> lessonOptional =
                this.lessonRepository.findById(lessonDTO.getId());
        if (lessonOptional.isPresent()){
            Lesson lesson = lessonOptional.get();
            lesson.setName(lessonDTO.getName());
            this.lessonRepository.save(lesson);
        }
    }

    @Override
    @Transactional
    public void deleteLesson(Long id) {
        this.lessonRepository.deleteById(id);

    }


}
