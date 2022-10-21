package com.example.resumeBackend.Service;

import com.example.resumeBackend.Model.WorkExperience;
import com.example.resumeBackend.Repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class WorkExperienceService {

    @Autowired
    WorkExperienceRepository workExperienceRepository;

//    @Transactional
    public WorkExperience getExperienceById(long id){
        Optional<WorkExperience> workExperience = workExperienceRepository.findById(id);
        if(workExperience.isEmpty()){
            return null;
        }

        WorkExperience experience = workExperience.get();
        System.out.println(experience);
        System.out.println(experience.getSkills());
        return experience;
    }
}
