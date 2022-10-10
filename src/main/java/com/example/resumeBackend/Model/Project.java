package com.example.resumeBackend.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    private String description;

    //TODO: can either be education or workExperience
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "EDUCATION_PROJECT",
            inverseJoinColumns = @JoinColumn(name = "education_id"),
            joinColumns = @JoinColumn(name = "project_id")
    )
    private Education college;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "EXPERIENCE_PROJECT",
            inverseJoinColumns = @JoinColumn(name = "experience_id"),
            joinColumns = @JoinColumn(name = "project_id")
    )
    private WorkExperience company;

    public Project() {}

    public Project(String title, Long typeId, Date dateFrom, Date dateTo, String description) {
        this.title = title;
        this.typeId = typeId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
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
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                '}';
    }
}
