package com.example.portfolio.Repository;

import com.example.portfolio.Model.WorkExperience;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkExperienceRepository extends CrudRepository<WorkExperience, Long> {

    List<WorkExperience> findAll();
}
