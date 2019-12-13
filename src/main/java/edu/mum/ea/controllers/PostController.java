package edu.mum.ea.controllers;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/post")
    public String makePost(@Valid Post post, BindingResult bindingResult,
                           @AuthenticationPrincipal UserPrincipal userPrincipal,
                           Model model) {
        if(!bindingResult.hasErrors()) {
            post.setUser(userPrincipal.getUser());
            post = postService.save(post);
            model.addAttribute("savedPost", post);
            return "redirect:/timeline";
        }
        return "timeline";
    }
}
