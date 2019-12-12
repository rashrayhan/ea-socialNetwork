package edu.mum.ea.controllers;

import edu.mum.ea.models.AccountStatus;
import edu.mum.ea.models.User;
import edu.mum.ea.services.UserService;
import org.eclipse.jdt.internal.compiler.apt.model.ModuleElementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

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

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(Model model) {
        userList=userService.findAll();
        model.addAttribute("userList", userList);
        return "users_all";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(!bindingResult.hasErrors()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAccountStatus(AccountStatus.Active);
            user.setUsername(user.getSurname());
            User retUser = (User) userService.save(user);
            redirectAttributes.addFlashAttribute("registeredUser", retUser);
            //return "redirect:/dashboard";
            return "redirect:/profile";

        }
        return "register";
    }


    @RequestMapping(value = "/profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard() {
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



}
