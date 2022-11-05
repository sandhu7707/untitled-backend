package com.example.portfolio.DTO;

import java.util.Date;
import java.util.List;

public class EducationDTO {

    private Long id;

    private String college;

    private String degree;

    private Date dateFrom;

    private Date dateTo;

    private String description;

    private List<Long> projectIds;

    public EducationDTO(
            Long id,
            String college,
            String degree,
            Date dateFrom,
            Date dateTo,
            String description,
            List<Long> projectIds
    ) {
        this.id = id;
        this.college = college;
        this.degree = degree;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.projectIds = projectIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public List<Long> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Long> projectIds) {
        this.projectIds = projectIds;
    }

    @Override
    public String toString() {
        return "EducationDTO{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", degree='" + degree + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                ", projectIds=" + projectIds +
                '}';
    }
}
