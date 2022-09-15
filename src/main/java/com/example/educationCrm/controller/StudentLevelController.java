package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentLevelDTO;
import com.example.educationCrm.service.StudentLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentLevel")
public class StudentLevelController {

    @Autowired
    private StudentLevelService studentLevelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudentLevel(@RequestBody StudentLevelDTO studentLevelDTO){
        this.studentLevelService.save(studentLevelDTO.getName());
    }

    @GetMapping
    public List<StudentLevelDTO> getAllLevel(){
        return this.studentLevelService.getStudentLevels();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLevel(@PathVariable Long id){
        this.studentLevelService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateLevel(@RequestBody StudentLevelDTO studentLevelDTO){
        this.studentLevelService.updateStudent(studentLevelDTO);
        return ResponseEntity.ok().build();
    }

}
