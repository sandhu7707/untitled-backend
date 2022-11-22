package com.example.portfolio.DTO;

import java.util.List;

public class ProfileDTO {

    private Long id;
    private List<SkillDTO> skillList;

    private List<EducationDTO> educationList;

    private List<WorkExperienceDTO> workExperienceList;

    private List<ProjectDTO> projectList;

    public ProfileDTO(
            Long id,
            List<SkillDTO> skillList,
            List<EducationDTO> educationList,
            List<WorkExperienceDTO> workExperienceList,
            List<ProjectDTO> projectList) {
        this.id = id;
        this.skillList = skillList;
        this.educationList = educationList;
        this.workExperienceList = workExperienceList;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SkillDTO> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<SkillDTO> skillList) {
        this.skillList = skillList;
    }

    public List<EducationDTO> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<EducationDTO> educationList) {
        this.educationList = educationList;
    }

    public List<WorkExperienceDTO> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperienceDTO> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<ProjectDTO> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectDTO> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "skillList=" + skillList +
                ", educationList=" + educationList +
                ", workExperienceList=" + workExperienceList +
                ", projectList=" + projectList +
                '}';
    }
}