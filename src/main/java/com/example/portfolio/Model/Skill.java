package com.example.portfolio.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SKILL")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int rating;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "SKILL_EXPERIENCE",
            joinColumns = @JoinColumn(name = "skills_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "experiences_id", referencedColumnName = "id"))
    private List<WorkExperience> workExperiences = new java.util.ArrayList<>();

    public Skill() {
    }

    public Skill(Long id, String title, int rating, Integer yearsOfExperience, List<WorkExperience> workExperiences) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.yearsOfExperience = yearsOfExperience;
        this.workExperiences = workExperiences;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> experience) {
        this.workExperiences = experience;
    }

    public void addWorkExperienceIfNotPresent(WorkExperience workExperience) {

        if(this.workExperiences.stream().noneMatch(w -> Objects.equals(w.getId(), workExperience.getId())))
            this.workExperiences.add(workExperience);
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
