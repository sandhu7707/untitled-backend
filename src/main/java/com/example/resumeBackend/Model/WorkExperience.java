package com.example.resumeBackend.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EXPERIENCE")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    private String description;

    @OneToMany(mappedBy = "experiences")
    private List<Skill> skills;

    @OneToMany(mappedBy = "college", cascade = CascadeType.REMOVE)
    private List<Project> projects;

    public WorkExperience() {}

    public WorkExperience(String company, String jobTitle, Date dateFrom, Date dateTo, String description, List<Skill> skills) {
        this.company = company;
        this.jobTitle = jobTitle;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
//        this.skills = skills;
    }

    public Long getId() {
        return id;
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

//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                '}';
    }
}