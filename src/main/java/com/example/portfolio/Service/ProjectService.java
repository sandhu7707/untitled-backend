package com.example.portfolio.Service;

import com.example.portfolio.DTO.ProjectDTO;
import com.example.portfolio.Model.Education;
import com.example.portfolio.Model.Project;
import com.example.portfolio.Model.WorkExperience;
import com.example.portfolio.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.portfolio.Mapper.DTOToEntity;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
