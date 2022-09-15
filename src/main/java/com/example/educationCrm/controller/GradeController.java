package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.*;
import com.example.educationCrm.model.entity.Grade;
import com.example.educationCrm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/getGrade")
    public ResponseEntity<GradeInformationDTO> getGradeById(@RequestParam Long id) {
        return new ResponseEntity<>(this.gradeService.getGradeById(id), HttpStatus.OK);
    }

    @PutMapping
    public void updateGrade(@RequestBody GradeDTO gradeDTO){
        this.gradeService.updateGrade(gradeDTO);

    }


    @PostMapping
    public ResponseEntity saveGrades(@RequestBody GradeDTO gradeDTO) throws ParseException {
        this.gradeService.save(gradeDTO);
        return new ResponseEntity("Başarılı Kayıt"
                , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGradeById(@PathVariable Long id){
        this.gradeService.deleteGrade(id);
        return ResponseEntity.ok().build();
    }
}
