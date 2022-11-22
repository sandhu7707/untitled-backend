package com.example.portfolio.Repository;

import com.example.portfolio.Model.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    Optional<UserInfo> findByUsername(String username);
}
