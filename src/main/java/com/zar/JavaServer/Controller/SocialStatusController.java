package com.zar.JavaServer.Controller;

import com.zar.JavaServer.SocialStatusRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SocialStatusController {
    private final SocialStatusRepository socialStatusRepository;

    public SocialStatusController(SocialStatusRepository socialStatusRepository) {
        this.socialStatusRepository = socialStatusRepository;
    }

    @GetMapping(value = "/socialstatuslist")
    public List getSocialStatuses(){
        return socialStatusRepository.findAll();
    }
}
