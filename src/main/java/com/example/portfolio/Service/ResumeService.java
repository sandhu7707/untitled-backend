package com.example.portfolio.Service;

import com.example.portfolio.DTO.ResumeDTO;
import com.example.portfolio.Mapper;
import com.example.portfolio.Model.Education;
import com.example.portfolio.Model.Project;
import com.example.portfolio.Model.Skill;

import com.example.portfolio.Model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.portfolio.Mapper.DTOToEntity;

@Service
public class ResumeService {

    @Autowired
    SkillService skillService;

    @Autowired
    ProjectService projectService;

    @Autowired
    WorkExperienceService workExperienceService;

    @Autowired
    EducationService educationService;

    public void saveResume(ResumeDTO resumeDTO) {

        List<WorkExperience> savedWorkExperiences = new ArrayList<>();
        List<Education> savedEducations = new ArrayList<>();

        resumeDTO.getWorkExperienceList().forEach(we -> {
            savedWorkExperiences.add(workExperienceService.createWorkExperience(DTOToEntity(we)));
        });

        resumeDTO.getEducationList().forEach(e -> {
            savedEducations.add(educationService.createEducation(DTOToEntity(e)));
        });

        resumeDTO.getSkillList().forEach(s -> {
            Skill skill = DTOToEntity(s);

            if (s.getExperienceIds() != null && !s.getExperienceIds().isEmpty()) {
                skill.setExperiences(
                        savedWorkExperiences.stream()
                                .filter(w -> s.getExperienceIds().contains(w.getId()))
                                .toList());
            }

            skillService.createSkill(skill);
        });

        resumeDTO.getProjectList().forEach(p -> {

            Project project = DTOToEntity(p);

            if (p.getType() == 'W') {

                savedWorkExperiences.stream()
                        .filter(we -> Objects.equals(p.getCompanyId(), we.getId()))
                        .findAny()
                        .ifPresent(project::setCompany);

            } else if (p.getType() == 'E') {

                savedEducations.stream()
                        .filter(e -> Objects.equals(p.getCollegeId(), e.getId()))
                        .findAny()
                        .ifPresent(project::setCollege);
            }

            projectService.createProject(project);
        });

    }

    public ResumeDTO getResume() {
        return new ResumeDTO(
                skillService.getSkills()
                        .stream().map(Mapper::entityToDTO)
                        .toList(),
                educationService.getEducations()
                        .stream().map(Mapper::entityToDTO)
                        .toList(),
                workExperienceService.getWorkExperiences()
                        .stream().map(Mapper::entityToDTO)
                        .toList(),
                projectService.getProjects()
                        .stream().map(Mapper::entityToDTO)
                        .toList()
        );
    }
}