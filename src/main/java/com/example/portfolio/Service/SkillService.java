package com.example.portfolio.Service;

import com.example.portfolio.Model.Skill;
import com.example.portfolio.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    WorkExperienceService workExperienceService;

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
