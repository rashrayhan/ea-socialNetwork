package edu.mum.ea.controllers;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.PostService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    PostService postService;
    UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping(value = "/post")
    public @ResponseBody String makePost(@Valid @ModelAttribute("newPost") Post post, BindingResult bindingResult,
                    @AuthenticationPrincipal UserPrincipal userPrincipal) {
            if(!bindingResult.hasErrors()) {
                post.setUser(userPrincipal.getUser());
                postService.save(post);
                return "Your post has been successfully submitted!";
            }
            return "Error";
    }

    @SubscribeMapping(value = "/test")
    public String testWebSocket(String message) {
        return "received:{" + message + "}";
    }

    @GetMapping("/timeline/data")
    public @ResponseBody List<Post> timelineData(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        User user = userPrincipal.getUser();
        return postService.getTimelinePosts(user);
    }
}








