package com.example.portfolio.Service;

import com.example.portfolio.Model.WorkExperience;
import com.example.portfolio.Repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService {

    @Autowired
    WorkExperienceRepository workExperienceRepository;

    public WorkExperience saveWorkExperience(WorkExperience workExperience) {

        return workExperienceRepository.save(workExperience);
    }

    public List<WorkExperience> getWorkExperiences() {

        return workExperienceRepository.findAll();
    }

    public WorkExperience getWorkExperienceById(long id) {

        return workExperienceRepository.findById(id).orElse(null);
    }
}
