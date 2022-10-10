package com.example.resumeBackend;

import com.example.resumeBackend.Model.Project;
import com.example.resumeBackend.Model.Skill;
import com.example.resumeBackend.Model.WorkExperience;
import com.example.resumeBackend.Repository.ProjectRepository;
import com.example.resumeBackend.Repository.SkillRepository;
import com.example.resumeBackend.Repository.WorkExperienceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ResumeBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(ResumeBackendApplication.class);

    @Autowired
    Environment env;

    public static void main(String[] args) {

        SpringApplication.run(ResumeBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(SkillRepository repository, WorkExperienceRepository workExperienceRepository) {
        return (args) -> {

//            log.info("property ->", env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));

//            repository.save(
//                    new Skill("JAVA", 9, 2, List.of(new WorkExperience("mastercard", "developer", new Date(), new Date(), "somethingsomething")))
//            );

                log.info(repository.findById(1013L).toString());
                log.info(repository.getExperiences(1013L).toString());
                log.info(workExperienceRepository.getSkills(1006L).toString());

//            for (Skill project : repository.findAll()) {
//                log.info(project.toString());
//                log.info(project.getExperiences().toString());
//            }

//
//            for (Skill skill : repository.findAll()) {
//                log.info(skill.toString());
//            }
//            log.info("-------------------------");
//
//            repository.findAllById(Collections.singleton(1L))
//                    .forEach(c -> log.info(c.toString()));
//            log.info("-------------------------");
//
//            repository.findByTitle("Regretstho")
//                    .forEach(c -> log.info(c.toString()));
//
//            log.info("------------------------------");
//
//            log.info(repository.testQuery(5).toString());
        };
    }

}
