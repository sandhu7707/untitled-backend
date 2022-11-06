package com.example.portfolio.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "project_type")
    private Character type;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    private String description;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "EDUCATION_PROJECT",
            inverseJoinColumns = @JoinColumn(name = "education_id"),
            joinColumns = @JoinColumn(name = "project_id")
    )
    private Education college;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "EXPERIENCE_PROJECT",
            inverseJoinColumns = @JoinColumn(name = "experience_id"),
            joinColumns = @JoinColumn(name = "project_id")
    )
    private WorkExperience company;

    public Project() {
    }

    public Project(
            Long id,
            String title,
            Character type,
            Date dateFrom,
            Date dateTo,
            String description
    ) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
    }

    public Long getId() {
        return id;
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

    public void setType(Character type) {
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

    public Education getCollege() {
        return college;
    }

    public void setCollege(Education college) {
        this.college = college;
    }

    public WorkExperience getCompany() {
        return company;
    }

    public void setCompany(WorkExperience company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                '}';
    }
}
