package edu.mum.ea.controllers;

import edu.mum.ea.models.Follow;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.FollowService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FollowController {

    FollowService followService;
    UserService userService;

    @Autowired
    public FollowController(FollowService followService, UserService userService) {
        this.followService = followService;
        this.userService = userService;
    }

    @GetMapping("/follow/{username}")
    public @ResponseBody boolean follow(@PathVariable("username") String username,
                   @AuthenticationPrincipal UserPrincipal userPrincipal) {
        Follow follow = new Follow();
        follow.setFollowingUser(userService.findByUsername(username));
        follow.setUser(userPrincipal.getUser());
        followService.save(follow);
        return true;
    }

    @GetMapping("/unfollow/{username}")
    public @ResponseBody boolean unfollow(@PathVariable("username") String username,
                                        @AuthenticationPrincipal UserPrincipal userPrincipal) {
        Follow follow = followService.findByFollowingUserAndUser(userService.findByUsername(username), userPrincipal.getUser());
        return followService.delete(follow);
    }
}
