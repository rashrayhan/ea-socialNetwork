package edu.mum.ea.controllers;

import edu.mum.ea.models.*;
import edu.mum.ea.services.PostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

     @Autowired
     PostItemService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {

        User user=new User("fikir","walle",
                   "fmwalle@mum.edu","123","123",
                   "wer","jjj","jkll",
                   new Address("usa","ia","fairf","1234"));

        Post pos=new Post("wert");
        PostItem pt=new PostItem(PostItemType.Mention,new SimpleUser(user),pos);


        System.out.println("777777777777777777777777777777777");
        System.out.println("777777777777777777777777777777777");

             postService.savepost(pt);

             System.out.println("********************************");





             return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";




    }





}
//