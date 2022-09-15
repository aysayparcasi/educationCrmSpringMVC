package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.StudentLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLevelRepository extends CrudRepository<StudentLevel,Long> {

}
