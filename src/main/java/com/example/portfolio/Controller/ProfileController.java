package com.example.portfolio.Controller;

import com.example.portfolio.DTO.ProfileDTO;
import com.example.portfolio.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//TODO no.2: see if we need this whole flow when we have userInfo saving profile

@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping
    void saveProfile(@Valid @RequestBody ProfileDTO profileDTO) {
        profileService.createProfile(profileDTO);
    }

    @GetMapping(path = "/{profileId}")
    ProfileDTO getProfile(@PathVariable Long profileId) {
        return profileService.getProfile(profileId);
    }

}
