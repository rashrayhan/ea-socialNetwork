package edu.mum.ea.controllers;

import edu.mum.ea.models.*;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.PostService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

          @Autowired
        UserService userservice;

  private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;

    }
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
         @RequestMapping(value = "/makepost",method = RequestMethod.GET)
              public String displaypost(Post post,User user){

                   //long userid=(long)userservice.findById(3L);

                          // System.out.println(userid);
             User user2=new User("fikir","nnn",LocalDate.now(),
              "fikirbereketu@gmail.com","fikirr","123456",
               AccountStatus.Active,"uu","llk",
              "jkl",
             new Address("fghj","uilk","jkl","gh"));

                     userservice.save(user2);

                     post.setUser(user2);
                   //  System.out.println(post.setCommentTo(post.setUser(user.getId())));
                     post.setCommentTo(post);






                  postService.save(post);





         return "timeline";


    }


    }









