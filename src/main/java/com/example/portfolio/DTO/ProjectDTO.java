package com.example.portfolio.DTO;

import java.util.Date;

public class ProjectDTO {

    private Long id;

    private String title;

    private char type;

    private Date dateFrom;

    private Date dateTo;

    private String description;

    private Long collegeId;

    private Long companyId;

    public ProjectDTO(
            Long id,
            String title,
            char type,
            Date dateFrom,
            Date dateTo,
            String description,
            Long collegeId,
            Long companyId
    ) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.collegeId = collegeId;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
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

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                ", collegeId=" + collegeId +
                ", companyId=" + companyId +
                '}';
    }
}
