package com.example.portfolio.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EDUCATION")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String college;

    private String degree;

    private Date dateFrom;

    private Date dateTo;

    private String description;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "college",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<Project> projects;

    public Education() {
    }

    public Education(
            Long id,
            String college,
            String degree,
            Date dateFrom,
            Date dateTo,
            String description
    ) {
        this.id = id;
        this.college = college;
        this.degree = degree;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
    }

    public Long getId() {
        return id;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", degree='" + degree + '\'' +
                ", date_from=" + dateFrom +
                ", date_to=" + dateTo +
                ", description='" + description + '\'' +
                '}';
    }
}
