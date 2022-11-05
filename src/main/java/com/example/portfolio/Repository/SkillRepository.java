package com.example.resumeBackend.Repository;

import com.example.resumeBackend.Model.Skill;
import com.example.resumeBackend.Model.WorkExperience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Long> {

    List<Skill> findByTitle(String skill);

    Skill findById(long id);

    @Query(
            value = "select e from Skill s " +
            "inner join s.experiences e " +
            "where s.id = ?1"
    )
    List<WorkExperience> getExperiences(long id);
}
