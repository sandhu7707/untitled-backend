package com.example.portfolio.Service;

import com.example.portfolio.DTO.UserInfoDTO;
import com.example.portfolio.Model.UserInfo;
import com.example.portfolio.Repository.UserInfoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.portfolio.Mapper.DTOToEntity;
import static com.example.portfolio.Mapper.entityToDTO;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    ProfileService profileService;

    public UserInfoDTO getUserInfo(String username){

        Optional<UserInfo> userInfo = userInfoRepository.findByUsername(username);

        if(userInfo.isEmpty())
            throw new Error(new Exception("no user found for given id"));

        return entityToDTO(userInfo.get());
    }
    public UserInfo saveUserInfo(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }

    public UserInfo createUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = saveUserInfo(
                DTOToEntity(userInfoDTO, profileService.createProfile(userInfoDTO.getProfile()))
        );

        return userInfo;
    }
}
