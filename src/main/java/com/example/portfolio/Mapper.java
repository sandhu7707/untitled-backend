package com.example.portfolio;

import com.example.portfolio.DTO.EducationDTO;
import com.example.portfolio.DTO.ProjectDTO;
import com.example.portfolio.DTO.SkillDTO;
import com.example.portfolio.DTO.WorkExperienceDTO;
import com.example.portfolio.Model.Education;
import com.example.portfolio.Model.Project;
import com.example.portfolio.Model.Skill;
import com.example.portfolio.Model.WorkExperience;

public class Mapper {

    public static Skill DTOToEntity(SkillDTO skillDTO) {
        return new Skill(
                skillDTO.getTitle(),
                skillDTO.getRating(),
                skillDTO.getYearsOfExperience()
        );
    }

    public static Project DTOToEntity(ProjectDTO projectDTO) {
        return new Project(
                projectDTO.getTitle(),
                projectDTO.getType(),
                projectDTO.getDateFrom(),
                projectDTO.getDateTo(),
                projectDTO.getDescription()
        );
    }

    public static WorkExperience DTOToEntity(WorkExperienceDTO workExperienceDTO) {
        return new WorkExperience(
                workExperienceDTO.getCompany(),
                workExperienceDTO.getJobTitle(),
                workExperienceDTO.getDateFrom(),
                workExperienceDTO.getDateTo(),
                workExperienceDTO.getDescription()
        );
    }

    public static Education DTOToEntity(EducationDTO educationDTO) {
        return new Education(
                educationDTO.getCollege(),
                educationDTO.getDegree(),
                educationDTO.getDateFrom(),
                educationDTO.getDateTo(),
                educationDTO.getDescription()
        );
    }

    public static WorkExperienceDTO entityToDTO(WorkExperience workExperience) {
        return new WorkExperienceDTO(
                workExperience.getId(),
                workExperience.getCompany(),
                workExperience.getJobTitle(),
                workExperience.getDateFrom(),
                workExperience.getDateTo(),
                workExperience.getDescription(),
                workExperience.getSkills().stream().map(Skill::getId).toList(),
                workExperience.getProjects().stream().map(Project::getId).toList()
        );
    }

    public static EducationDTO entityToDTO(Education education) {
        return new EducationDTO(
                education.getId(),
                education.getCollege(),
                education.getDegree(),
                education.getDateFrom(),
                education.getDateTo(),
                education.getDescription(),
                education.getProjects().stream().map(Project::getId).toList()
        );
    }

    public static SkillDTO entityToDTO(Skill skill) {
        return new SkillDTO(
                skill.getId(),
                skill.getTitle(),
                skill.getRating(),
                skill.getYearsOfExperience(),
                skill.getExperiences().stream().map(WorkExperience::getId).toList()
        );
    }

    public static ProjectDTO entityToDTO(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getTitle(),
                project.getType(),
                project.getDateFrom(),
                project.getDateTo(),
                project.getDescription(),
                getIdIfNotNull(project.getCollege()),
                getIdIfNotNull(project.getCompany())
        );
    }

    private static Long getIdIfNotNull(Education education){
        if(education != null){
            return education.getId();
        }
        return null;
    }

    private static Long getIdIfNotNull(WorkExperience workExperience){
        if(workExperience != null){
            return workExperience.getId();
        }
        return null;
    }
}
