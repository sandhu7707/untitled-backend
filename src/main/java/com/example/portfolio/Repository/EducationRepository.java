package com.example.portfolio.Repository;

import com.example.portfolio.Model.Education;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationRepository extends CrudRepository<Education, Long> {

    List<Education> findAll();
}
