package com.example.portfolio.Service;

import com.example.portfolio.Model.Education;
import com.example.portfolio.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    EducationRepository educationRepository;

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public List<Education> getEducations() {
        return educationRepository.findAll();
    }
}
