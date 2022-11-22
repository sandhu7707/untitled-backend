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
    private Education college;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private WorkExperience company;

    public Project() {
    }

    public Project(Long id, String title, Character type, Date dateFrom, Date dateTo, String description, Education college, WorkExperience company) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.college = college;
        this.company = company;
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
        if(this.company == null) {
            this.college = college;
        }
        else{
            throw new Error(new Exception(" project can't have both company and college id "));
        }
    }

    public WorkExperience getCompany() {
        return company;
    }

    public void setCompany(WorkExperience company) {
        if(this.college == null){
            this.company = company;
        }
        else{
            throw new Error(new Exception(" project can't have both company and college id "));
        }
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
