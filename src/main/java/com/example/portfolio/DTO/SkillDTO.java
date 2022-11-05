package com.example.portfolio.DTO;

import java.util.List;

public class SkillDTO {

    private Long id;
    private String title;

    private int rating;

    private Integer yearsOfExperience;

    private List<Long> experienceIds;

    public SkillDTO(
            Long id,
            String title,
            int rating,
            Integer yearsOfExperience,
            List<Long> experienceIds
    ) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.yearsOfExperience = yearsOfExperience;
        this.experienceIds = experienceIds;
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

    public List<Long> getExperienceIds() {
        return experienceIds;
    }

    public void setExperienceIds(List<Long> experienceIds) {
        this.experienceIds = experienceIds;
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", yearsOfExperience=" + yearsOfExperience +
                ", experienceIds=" + experienceIds +
                '}';
    }
}
