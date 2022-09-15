package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity saveSchool(@RequestBody SchoolDTO schoolDTO){
        //String olduğu için postmanda Json çevirme işlemi yapamıyor. Bu yüzden DTO ile yapıyoruz.
        //Ama DTO olsa çevirirdi. Genelde tek field için DTO yapılmaz.
        this.schoolService.save(schoolDTO.getName());
        return new ResponseEntity("Başarılı işlem", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool(@PathVariable Long id){
        this.schoolService.deleteSchool(id);
    }

    @PostMapping("/addListSchool")
    @ResponseStatus(HttpStatus.CREATED)
    public void addListSchool(@RequestBody List<SchoolDTO> schoolDTOList){
        this.schoolService.addListSchool(schoolDTOList);
    }


    @GetMapping
    public List<SchoolDTO> getAllSchool(){
        return this.schoolService.getAllSchool();
    }

}
