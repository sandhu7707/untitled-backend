package com.example.portfolio.Model;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<WorkExperience> experiences;

    public Skill() {
    }

    public Skill(String title, int rating, int yearsOfExperience) {
        this.title = title;
        this.rating = rating;
        this.yearsOfExperience = yearsOfExperience;
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

    public List<WorkExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<WorkExperience> experience) {
        this.experiences = experience;
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
