package com.example.portfolio.Service;

import com.example.portfolio.Model.Project;
import com.example.portfolio.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
