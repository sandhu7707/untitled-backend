package com.example.resumeBackend.Repository;

import com.example.resumeBackend.Model.Skill;
import com.example.resumeBackend.Model.WorkExperience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkExperienceRepository extends CrudRepository<WorkExperience, Long> {

    @Query(
            value = "select s from WorkExperience e " +
                    "inner join e.skills s " +
                    "where e.id = ?1 "
    )
    List<Skill> getSkills(long id);
}
