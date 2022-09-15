package com.example.educationCrm.controller;


import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private StudentRepository studentRepository;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLesson(@RequestBody LessonDTO lessonDTO ) throws SQLDataException {
        this.lessonService.save(lessonDTO.getName());
    }

    @GetMapping("/allLessons")
    public List<LessonDTO> getLessons(){
        return this.lessonService.getLessons();
    }

    @PostMapping("/addListLesson")
    @ResponseStatus(HttpStatus.CREATED)
    public void addListLesson(@RequestBody List<LessonDTO> lessonDTOList){
        this.lessonService.addListLesson(lessonDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLesson(@PathVariable Long id){
        this.lessonService.deleteLesson(id);
        return  ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateLesson(@RequestBody LessonDTO lessonDTO){
        this.lessonService.updateLesson(lessonDTO);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/student/{studentId}/lesson")
    public ResponseEntity<List<Lesson>> getAllLessonsByStudentsId(
            @PathVariable(value = "studentId") Long studentId) {
        if (!studentRepository.existsById(studentId)){
            throw new RuntimeException("Not found student with id = " + studentId);
        }
        List<Lesson> lessons = lessonRepository.findLessonsByStudentsId(studentId);
        return new ResponseEntity<>(lessons,HttpStatus.OK);
    }









    @PostMapping("/student/{studentId}/lesson")
    public ResponseEntity<Lesson> addLesson(
            @PathVariable(value = "studentId") Long studentId,
            @RequestBody Lesson lessonRequest) {
        Lesson lesson = studentRepository.findById(studentId).map(student -> {
            long lessonId = lessonRequest.getId();

            // lesson is existed
            if (lessonId != 0L) {
                Lesson lesson1 = lessonRepository.findById(lessonId)
                        .orElseThrow(() -> new RuntimeException("Not found Lesson with id = " + lessonId));
                student.addLesson(lesson1);
                studentRepository.getStudentById(studentId);
                return lesson1;
            }

            // add and create new Lesson
            student.addLesson(lessonRequest);
            return lessonRepository.save(lessonRequest);
        }).orElseThrow(() -> new RuntimeException("Not found Tutorial with id = " + studentId));
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }









}
