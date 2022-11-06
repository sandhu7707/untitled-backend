package com.example.portfolio.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    /*
      using Sets instead of List to avoid MultipleBagFetchException,
      MultipleBagFetchException is caused by hibernate as it can't do mapping for all the columns correctly for all the entities after cartesian product is formed if we use list, somehow,
      it works for sets though!
      TODO: To make it more efficient,
      you can lazy load these two fields and write queries
      to load one at a time, avoiding cartesian product by using distinct parameters in queries
    * */
    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "experiences",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<Skill> skills;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "company",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<Project> projects;

    public List<Skill> getSkills() {
        return skills.stream().toList();
    }

    public WorkExperience() {
    }

    public WorkExperience(
            Long id,
            String company,
            String jobTitle,
            Date dateFrom,
            Date dateTo,
            String description
    ) {
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
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