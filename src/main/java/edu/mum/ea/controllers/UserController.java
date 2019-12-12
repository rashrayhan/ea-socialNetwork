package edu.mum.ea.controllers;

import edu.mum.ea.models.Advert;
import edu.mum.ea.models.User;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = {"/", "/login", "/index"}, method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(!bindingResult.hasErrors()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User retUser = (User) userService.save(user);
            redirectAttributes.addFlashAttribute("registeredUser", retUser);
            return "redirect:/dashboard";
        }
        return "register";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(@ModelAttribute("advert") Advert advert) {
        return "dashboard";
    }

    @RequestMapping(value = "/timeline")
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

    @RequestMapping(value = "/follow")
    public String follow() {
        return "follow";
    }

    @RequestMapping(value = "/profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping(value = "/user_profile")
    public String user_profile() {
        return "user_profile";
    }

    @RequestMapping(value = "/claim")
    public String claim() {
        return "claim";
    }

}
