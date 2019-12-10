package edu.mum.ea.controllers;

import edu.mum.ea.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FollowController {

    FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }
}
