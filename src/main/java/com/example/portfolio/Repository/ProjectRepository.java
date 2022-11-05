package com.example.portfolio.Repository;

import com.example.portfolio.Model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAll();
}
