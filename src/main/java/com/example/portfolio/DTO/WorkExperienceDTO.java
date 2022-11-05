package com.example.portfolio.DTO;

import java.util.Date;
import java.util.List;

public class WorkExperienceDTO {

    private Long id;
    private String company;

    private String jobTitle;

    private Date dateFrom;

    private Date dateTo;

    private String description;

    private List<Long> skillIds;

    private List<Long> projectIds;

    public WorkExperienceDTO(
            Long id,
            String company,
            String jobTitle,
            Date dateFrom,
            Date dateTo,
            String description,
            List<Long> skillIds,
            List<Long> projectIds
    ) {
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.skillIds = skillIds;
        this.projectIds = projectIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Long> skillIds) {
        this.skillIds = skillIds;
    }

    public List<Long> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Long> projectIds) {
        this.projectIds = projectIds;
    }

    @Override
    public String toString() {
        return "WorkExperienceDTO{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                ", skillIds=" + skillIds +
                ", projectIds=" + projectIds +
                '}';
    }
}
