package com.example.portfolio.DTO;

import java.util.List;

public class SkillDTO {

    private Long id;
    private String title;

    private int rating;

    private Integer yearsOfExperience;

    private List<Long> workExperienceIds;

    public SkillDTO(
            Long id,
            String title,
            int rating,
            Integer yearsOfExperience,
            List<Long> workExperienceIds
    ) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.yearsOfExperience = yearsOfExperience;
        this.workExperienceIds = workExperienceIds;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<Long> getWorkExperienceIds() {
        return workExperienceIds;
    }

    public void setWorkExperienceIds(List<Long> workExperienceIds) {
        this.workExperienceIds = workExperienceIds;
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", yearsOfExperience=" + yearsOfExperience +
                ", experienceIds=" + workExperienceIds +
                '}';
    }
}
