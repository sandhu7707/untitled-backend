package com.example.portfolio.DTO;

import java.util.List;

public class ResumeDTO {

    private List<SkillDTO> skillList;

    private List<EducationDTO> educationList;

    private List<WorkExperienceDTO> workExperienceList;

    private List<ProjectDTO> projectList;

    public ResumeDTO(
            List<SkillDTO> skillList,
            List<EducationDTO> educationList,
            List<WorkExperienceDTO> workExperienceList,
            List<ProjectDTO> projectList
    ) {
        this.skillList = skillList;
        this.educationList = educationList;
        this.workExperienceList = workExperienceList;
        this.projectList = projectList;
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
        return "ResumeDTO{" +
                "skillList=" + skillList +
                ", educationList=" + educationList +
                ", workExperienceList=" + workExperienceList +
                ", projectList=" + projectList +
                '}';
    }
}