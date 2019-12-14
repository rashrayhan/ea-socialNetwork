package edu.mum.ea.controllers;

import edu.mum.ea.models.AccountStatus;
import edu.mum.ea.models.Address;
import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.PostService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.time.LocalDate;
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

    @RequestMapping(value = "/makepost", method = RequestMethod.GET)
    public String displaypost(Post post, User user, Model model) {


        User user2 = new User("fikir", "nnn", LocalDate.now(),
                "fikirbereketu@gmail.com", "fikirr", "123456",
                AccountStatus.Active, "uu", "llk",
                "jkl",
                new Address("fghj", "uilk", "jkl", "gh"));

        post.setUser(user2);
        userService.save(user2);
        postService.save(post);

        List<Post> postlist = postService.findAll();
        model.addAttribute("posts", postlist);


        return "timeline";


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









