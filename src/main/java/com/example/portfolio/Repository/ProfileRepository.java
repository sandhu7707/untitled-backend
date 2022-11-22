package com.example.portfolio.Repository;

import com.example.portfolio.Model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
