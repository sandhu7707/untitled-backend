package com.example.portfolio.Repository;

import com.example.portfolio.Model.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends CrudRepository<Skill, Long> {

    List<Skill> findAll();
}
