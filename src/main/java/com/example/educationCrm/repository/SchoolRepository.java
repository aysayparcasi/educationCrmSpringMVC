package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School,Long> {
}
