package edu.mum.ea.controllers;

<<<<<<< HEAD
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.PostService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
=======
import edu.mum.ea.models.AccountStatus;
import edu.mum.ea.models.Address;
import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
import java.util.List;

@Controller
public class PostController {

<<<<<<< HEAD

    @Autowired
    MypostService mypostService;

    @Autowired
    UserService userService;


    //    @RequestMapping(value = "/please", method = RequestMethod.GET)
//    public String indexco(){
////        System.out.println("*********************");
////
////        User user2=new User("fikir","nnn",LocalDate.now(),
////                "fikirbereketu@gmail.com","fikirr","123456",
////                AccountStatus.Active,"uu","llk",
////                "jkl",
////                new Address("fghj","uilk","jkl","gh"));
////
////
////                User user=new User("fikir","nnn",LocalDate.now(),
////                        "fikirbereketu@gmail.com","fikirr","123456",
////                        AccountStatus.Active,"uu","llk",
////                        "jkl",
////                        new Address("fghj","uilk","jkl","gh"));
////
////                  userservice.save(user2);
////                 userservice.save(user);
////
////
////
////          Post post=new Post("hello",null,user);
////       postService.save(post);
////
////      Post comment = new Post("comment",post,user2);
////     comment = (Post) postService.save(comment);
//
//
//
//
//        return "index";
    @RequestMapping(value = "/makepost", method = RequestMethod.GET)
    public String displaypost(Post post, User user, Model model, @AuthenticationPrincipal UserPrincipal userPrincipal) {
=======
    PostService postService;
    UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(value = "/makepost", method = RequestMethod.GET)
    public String displaypost(Post post, User user, Model model) {
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e


        User user2 = new User("fikir", "nnn", LocalDate.now(),
                "fikirbereketu@gmail.com", "fikirr", "123456",
                AccountStatus.Active, "uu", "llk",
                "jkl",
                new Address("fghj", "uilk", "jkl", "gh"));

<<<<<<< HEAD
        User user3 = new User("Rashid", "nnn", LocalDate.now(),
                "rashid@gmail.com", "ahmed", "123456",
                AccountStatus.Active, "uu", "llk",
                "jkl",
                new Address("fghj", "uilk", "jkl", "gh"));

        post.setUser(userPrincipal.getUser());

        userService.save(user2);
        mypostService.save(post);
        user=userService.findById(user.getId());


        List<Post> postlist = mypostService.getAll();
        model.addAttribute("posts", postlist);
        model.addAttribute("userid",user);

       // Post userpost=mypostService.save(post);
                ;
//               post.setUser(user3);
//               post.setCommentTo(userpost.setUser(user3));
=======
        post.setUser(user2);
        userService.save(user2);
        postService.save(post);

        List<Post> postlist = postService.findAll();
        model.addAttribute("posts", postlist);

>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e

        return "timeline";


<<<<<<< HEAD
=======
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
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
    }


}









