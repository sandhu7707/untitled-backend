package com.example.resumeBackend.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EDUCATION")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String college;

    private String degree;
    
    private Date date_from;
    
    private Date date_to;
    
    private String description;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "college",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<Project> projects;

    public Education(){}

    public Education(String college, String degree, Date date_from, Date date_to, String description) {
        this.college = college;
        this.degree = degree;
        this.date_from = date_from;
        this.date_to = date_to;
        this.description = description;
    }

    public long getId() {
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

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", degree='" + degree + '\'' +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", description='" + description + '\'' +
                '}';
    }
}
