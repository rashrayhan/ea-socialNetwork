package edu.mum.ea.controllers;

import edu.mum.ea.models.User;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

<<<<<<< HEAD
    public UserController() {
    }



    @RequestMapping(value = {"/", "/login", "/index"}, method = RequestMethod.GET)

=======
    @GetMapping(value = {"/", "/login", "/index"})
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
    public String welcome() {
        return "index";
    }


    @GetMapping(value = "/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String postRegister(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(!bindingResult.hasErrors()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User retUser = (User) userService.save(user);
            redirectAttributes.addFlashAttribute("registeredUser", retUser);
            return "redirect:/dashboard";
        }
        return "register";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard() {
        return "dashboard";
    }

<<<<<<< HEAD
    @RequestMapping(value = "/timeline" ,method = RequestMethod.GET)
=======
    @GetMapping(value = "/timeline")
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
    public String timeline() {
        return "timeline";
    }



    @RequestMapping(value = "/filthy")
    public String filthy() {
        return "filthy";
    }

    @RequestMapping(value = "/users_all")
    public String users_all() {
        return "users_all";
    }

    @RequestMapping(value = "/user_claims")
    public String user_claims() {
        return "user_claims";
    }

    @RequestMapping(value = "/filthy_words")
    public String filthy_words() {
        return "filthy_words";
    }




}
