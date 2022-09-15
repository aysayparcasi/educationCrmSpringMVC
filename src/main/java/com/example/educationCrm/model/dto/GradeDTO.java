package com.example.educationCrm.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GradeDTO {
    private Long id;
    private Double grade;
    private Long studentId;
    private Long teacherId;
   // private StudentDTO studentDTO;


}
