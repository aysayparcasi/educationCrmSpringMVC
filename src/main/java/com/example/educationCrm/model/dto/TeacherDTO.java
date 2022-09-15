package com.example.educationCrm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TeacherDTO {
    private Long id;
    private String name;
    private String surname;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private Long lesson_id;
    private Long school_id;
}
