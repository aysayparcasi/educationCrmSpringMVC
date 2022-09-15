package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody StudentDTO studentDTO) throws ParseException {
        this.studentService.save(studentDTO);
        return new ResponseEntity("Başarılı Kayıt"
                , HttpStatus.CREATED);
    }

    @GetMapping("/getNameSurname")
    public ResponseEntity<StudentInformationDTO> getNameSurnameById(@RequestParam Long id){
        return new ResponseEntity<>(this.studentService.getNameSurnameById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById(@PathVariable Long id){
        this.studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/addListStudent")
    public void addListStudent(@RequestBody List<StudentDTO> studentDTOList){
        this.studentService.addStudentList(studentDTOList);
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentDTO studentDTO){
        this.studentService.updateStudent(studentDTO);

    }

    @GetMapping("/lesson/{lessonId}/student")
    public ResponseEntity<List<Student>> getAllLessonsByStudentsId(
            @PathVariable(value = "lessonId") Long lessonId) {
        if (!lessonRepository.existsById(lessonId)){
            throw new RuntimeException("Not found student with id = " + lessonId);
        }
        List<Student> students = studentRepository.findStudentByLessonsId(lessonId);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
}
