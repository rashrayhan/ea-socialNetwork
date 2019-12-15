package edu.mum.ea.controllers;

import edu.mum.ea.models.*;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.AddressService;
import edu.mum.ea.services.UserService;
import org.eclipse.jdt.internal.compiler.apt.model.ModuleElementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    @Autowired
    private ServletContext context;
   // AppProperties appProperties;

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
            user.setProfilePhoto("default.png");
            User retUser = (User) userService.save(user);
            redirectAttributes.addFlashAttribute("registeredUser", retUser);
            return "redirect:/login";

        }
        return "register";
    }



    @RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
    public String updateProfile(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(!bindingResult.hasErrors()) {
            User object =  userService.findById(user.getId());
            object.setUsername(user.getUsername());
            object.setBiography(user.getBiography());
            object.setDateOfBirth(user.getDateOfBirth());

            Address address = addressService.save(user.getAddress());
            object.setAddress(address);

            User retUser = (User) userService.update(object);
            return "redirect:/profile";
        }
        return "timeline";
    }

    @RequestMapping(value = "/updateProfilePicture", method = RequestMethod.POST)
    public String updatePicture(MultipartFile file, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        try {
            if(file.getBytes().length>0){
            User user = userPrincipal.getUser();
            String picture = userService.editProfilePicture(file);
            user.setProfilePhoto(picture);
            userService.update(user);}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/profile";
        }

    @RequestMapping(value = "/profile")
    public String profile(@AuthenticationPrincipal UserPrincipal userPrincipal, Model model)
    {
        User user = userPrincipal.getUser();
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = "/updateprofile")
    public String getUpdateProfile()
    {
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
