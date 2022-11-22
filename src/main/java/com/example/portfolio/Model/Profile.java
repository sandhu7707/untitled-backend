package com.example.portfolio.Model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="PROFILE")
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinTable(name = "PROFILE_SKILL")
    private List<Skill> skillList;

    @OneToMany
    @JoinTable(name = "PROFILE_WORK_EXPERIENCE")
    private List<WorkExperience> workExperienceList;

    @OneToMany
    @JoinTable(name = "PROFILE_PROJECT")
    private List<Project> projectList;

    @OneToMany
    @JoinTable(name = "PROFILE_EDUCATION")
    private List<Education> educationList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }
}