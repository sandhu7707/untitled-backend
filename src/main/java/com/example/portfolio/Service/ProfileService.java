package com.example.portfolio.Service;

import com.example.portfolio.DTO.*;

import com.example.portfolio.Model.*;
import com.example.portfolio.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.portfolio.Mapper.DTOToEntity;
import static com.example.portfolio.Mapper.entityToDTO;

@Service
public class ProfileService {

    @Autowired
    SkillService skillService;

    @Autowired
    ProjectService projectService;

    @Autowired
    WorkExperienceService workExperienceService;

    @Autowired
    EducationService educationService;

    @Autowired
    ProfileRepository profileRepository;

    //TODO no.1 : {make sure frontend keeps in sync with skills, projects, etc.
    // they could be saved individually.}
    // this is to avoid contradiction in associations from different sides of the association
    // {other way would be to introduce that logic in frontend
    // or restrict work experiences and education from saving skills, projects and only allow it from the other side..}
    // decide which way is better when progressing with fe.
    public Profile createProfile(ProfileDTO profileDTO) {

        Profile profile = new Profile();

        List<WorkExperienceDTO> workExperienceDTOList = profileDTO.getWorkExperienceList();
        List<EducationDTO> educationDTOList = profileDTO.getEducationList();
        List<ProjectDTO> projectDTOList = profileDTO.getProjectList();
        List<SkillDTO> skillDTOList = profileDTO.getSkillList();

        profile.setId(profileDTO.getId());

        if(workExperienceDTOList != null && !workExperienceDTOList.isEmpty())
            profile.setWorkExperienceList(workExperienceDTOList.stream().map(this::createOrUpdateWorkExperience).toList());

        if(educationDTOList != null && !educationDTOList.isEmpty())
            profile.setEducationList(educationDTOList.stream().map(this::createOrUpdateEducation).toList());

        if(projectDTOList != null && !projectDTOList.isEmpty())
            profile.setProjectList(projectDTOList.stream().map(this::createOrUpdateProject).toList());

        if(skillDTOList != null && !skillDTOList.isEmpty())
            profile.setSkillList(skillDTOList.stream().map(this::createOrUpdateSkill).toList());

        return profileRepository.save(profile);
    }

    private Education createOrUpdateEducation(EducationDTO educationDTO) {

        if(educationDTO.getProjectIds() != null)
            educationDTO.getProjectIds().stream().map(projectId -> projectService.getProjectById(projectId))
                    .filter(Objects::nonNull)
                    .forEach(project -> {
                        project.setCollege(DTOToEntity(educationDTO));
                        projectService.saveProject(project);
                    });

        return educationService.saveEducation(DTOToEntity(educationDTO));
    }

    public WorkExperience createOrUpdateWorkExperience(WorkExperienceDTO workExperienceDTO) {

        if(workExperienceDTO.getSkillIds() != null)
            workExperienceDTO.getSkillIds().stream().map(skillId -> skillService.getSkillById(skillId))
                    .filter(Objects::nonNull)
                    .forEach(
                            skill -> {
                                skill.addWorkExperienceIfNotPresent(DTOToEntity(workExperienceDTO));
                                skillService.saveSkill(skill);
                            }
                    );

        if(workExperienceDTO.getProjectIds() != null)
            workExperienceDTO.getProjectIds().stream().map(projectId -> projectService.getProjectById(projectId))
                    .filter(Objects::nonNull)
                    .forEach(
                            project -> {
                                project.setCompany(DTOToEntity(workExperienceDTO));
                                projectService.saveProject(project);
                            }
                    );

        return workExperienceService.saveWorkExperience(DTOToEntity(workExperienceDTO));
    }

    public Skill createOrUpdateSkill(SkillDTO skillDTO) {
        return skillService.saveSkill(
                DTOToEntity(
                        skillDTO,
                        skillDTO.getWorkExperienceIds().stream().map(workExperienceId -> workExperienceService.getWorkExperienceById(workExperienceId))
                                .filter(Objects::nonNull).toList()
                ));
    }

    public Project createOrUpdateProject(ProjectDTO projectDTO) {

        if(projectDTO.getCompanyId() != null && projectDTO.getCollegeId() != null)
            throw new Error(new Exception(" project can't have both company and college id "));

        Education college = projectDTO.getCollegeId() != null ? educationService.getEducationById(projectDTO.getCollegeId()) : null;
        WorkExperience company = projectDTO.getCompanyId() != null ? workExperienceService.getWorkExperienceById(projectDTO.getCompanyId()) : null;

        return projectService.saveProject(
                DTOToEntity(
                        projectDTO,
                        college,
                        company
                ));
    }

    public ProfileDTO getProfile(Long profileId) {

        Optional<Profile> profile = profileRepository.findById(profileId);

        if(profile.isEmpty())
            throw new Error(new Exception(" profile not found "));

        return entityToDTO(profile.get());
    }
}