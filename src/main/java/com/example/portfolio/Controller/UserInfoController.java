package com.example.portfolio.Controller;

import com.example.portfolio.DTO.UserInfoDTO;
import com.example.portfolio.Model.UserInfo;
import com.example.portfolio.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping(path="/{username}")
    public UserInfoDTO getUserInfo(@PathVariable  String username){
        return userInfoService.getUserInfo(username);
    }

    @PostMapping
    public void postUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        userInfoService.createUserInfo(userInfoDTO);
    }
}
