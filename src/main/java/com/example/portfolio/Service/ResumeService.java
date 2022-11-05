package com.example.portfolio.Service;

import com.example.portfolio.DTO.ResumeDTO;
import com.example.portfolio.Mapper;
import com.example.portfolio.Model.Project;
import com.example.portfolio.Model.Skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //TODO: saves some of the things multiple times
    public void saveResume(ResumeDTO resumeDTO) {

        resumeDTO.getSkillList().forEach(s -> {
            Skill skill = DTOToEntity(s);

            if (s.getYearsOfExperience() != 0) {
                skill.setExperiences(
                        resumeDTO.getWorkExperienceList().stream()
                                .filter(w -> s.getExperienceIds().contains(w.getId()))
                                .map(Mapper::DTOToEntity).toList());
            }

            skillService.createSkill(skill);
        });

        resumeDTO.getProjectList().forEach(p -> {
            Project project = DTOToEntity(p);

            if (p.getType() == 'W') {

                resumeDTO.getWorkExperienceList().stream()
                        .filter(we -> p.getCompanyId() == we.getId())
                        .findAny()
                        .ifPresent(experienceDTO -> project.setCompany(DTOToEntity(experienceDTO)));
            } else if (p.getType() == 'E') {

                resumeDTO.getEducationList().stream()
                        .filter(e -> p.getCollegeId() == e.getId())
                        .findAny()
                        .ifPresent(educationDTO -> project.setCollege(DTOToEntity(educationDTO)));
            }

            projectService.createProject(project);
        });

        resumeDTO.getWorkExperienceList().forEach(we -> {
            workExperienceService.createWorkExperience(DTOToEntity(we));
        });

        resumeDTO.getEducationList().forEach(e -> {
            educationService.createEducation(DTOToEntity(e));
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