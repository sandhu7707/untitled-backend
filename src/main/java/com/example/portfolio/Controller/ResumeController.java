package com.example.portfolio.Controller;

import com.example.portfolio.DTO.ResumeDTO;
import com.example.portfolio.Service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/resume")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @PostMapping
    void saveResume(@Valid @RequestBody ResumeDTO resumeDTO) {
        resumeService.saveResume(resumeDTO);    //TODO: test overwriting and other cases !
    }

    @GetMapping
    ResumeDTO getResume() {
        return resumeService.getResume();
    }

}
