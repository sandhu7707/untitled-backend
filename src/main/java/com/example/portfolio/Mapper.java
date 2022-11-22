package com.example.portfolio;

import com.example.portfolio.DTO.*;
import com.example.portfolio.Model.*;
import com.example.portfolio.Service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Mapper {

    @Autowired
    WorkExperienceService workExperienceService;

    public static Skill DTOToEntity(SkillDTO skillDTO, List<WorkExperience> workExperienceList) {
        return new Skill(
                skillDTO.getId(),
                skillDTO.getTitle(),
                skillDTO.getRating(),
                skillDTO.getYearsOfExperience(),
                workExperienceList
        );
    }

    public static Project DTOToEntity(ProjectDTO projectDTO, Education college, WorkExperience company) {
        return new Project(
                projectDTO.getId(),
                projectDTO.getTitle(),
                projectDTO.getType(),
                projectDTO.getDateFrom(),
                projectDTO.getDateTo(),
                projectDTO.getDescription(),
                college,
                company
        );
    }

    public static WorkExperience DTOToEntity(WorkExperienceDTO workExperienceDTO) {
        return new WorkExperience(
                workExperienceDTO.getId(),
                workExperienceDTO.getCompany(),
                workExperienceDTO.getJobTitle(),
                workExperienceDTO.getDateFrom(),
                workExperienceDTO.getDateTo(),
                workExperienceDTO.getDescription()
        );
    }

    public static Education DTOToEntity(EducationDTO educationDTO) {
        return new Education(
                educationDTO.getId(),
                educationDTO.getCollege(),
                educationDTO.getDegree(),
                educationDTO.getDateFrom(),
                educationDTO.getDateTo(),
                educationDTO.getDescription()
        );
    }

    public static UserInfo DTOToEntity(UserInfoDTO userInfoDTO, Profile profile) {
        return new UserInfo(
                userInfoDTO.getId(),
                userInfoDTO.getFirstName(),
                userInfoDTO.getLastName(),
                userInfoDTO.getContactNumber(),
                userInfoDTO.getEmailAddress(),
                profile,
                userInfoDTO.getUsername(),
                userInfoDTO.getPassword()
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
                skill.getWorkExperiences().stream().map(WorkExperience::getId).toList()
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

    public static ProfileDTO entityToDTO(Profile profile) {
        return new ProfileDTO(
                profile.getId(),
                profile.getSkillList().stream().map(Mapper::entityToDTO).toList(),
                profile.getEducationList().stream().map(Mapper::entityToDTO).toList(),
                profile.getWorkExperienceList().stream().map(Mapper::entityToDTO).toList(),
                profile.getProjectList().stream().map(Mapper::entityToDTO).toList()
        );
    }

    public static UserInfoDTO entityToDTO (UserInfo userInfo){
        return new UserInfoDTO(
                userInfo.getId(),
                entityToDTO(userInfo.getProfile()),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getContactNumber(),
                userInfo.getEmailAddress()
                // not sending username and password, fix the security stuff first
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
