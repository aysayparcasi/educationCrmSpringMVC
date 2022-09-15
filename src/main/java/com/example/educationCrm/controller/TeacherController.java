package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.TeacherDTO;
import com.example.educationCrm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherDTO> getAll(){
        return this.teacherService.findAll();
    }

    @PostMapping
    public void save(@RequestBody TeacherDTO teacherDTO){
        this.teacherService.save(teacherDTO);
    }

    @PutMapping
    public void update(@RequestBody TeacherDTO teacherDTO){
        this.teacherService.update(teacherDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long teacherId){
        this.teacherService.delete(teacherId);
    }
}
