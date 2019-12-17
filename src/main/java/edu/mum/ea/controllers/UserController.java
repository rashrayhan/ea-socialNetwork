package edu.mum.ea.controllers;

import edu.mum.ea.models.*;
import edu.mum.ea.models.util.ProfileFollowInfo;
import edu.mum.ea.models.util.ProfileUserInfo;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.AddressService;
import edu.mum.ea.services.FollowService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    private FollowService followService;

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
    public UserController(PasswordEncoder passwordEncoder, UserService userService, FollowService followService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.followService = followService;
    }

    @GetMapping(value = {"/", "/login", "/index"})
    public String welcome() {
        return "index";
    }


    @GetMapping(value = "/register")
    public String getRegister() {
        return "register";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(Model model) {
        userList=userService.findAll();
        model.addAttribute("userList", userList);
        return "users_all";
    }
    @PostMapping(value = "/register")
    public String postRegister(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
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
    @GetMapping(value = "/dashboard")
    public String dashboard(@ModelAttribute("advert") Advert advert) {

        return "dashboard";
    }

    @GetMapping(value = "/timeline")
    public String timeline(@ModelAttribute("newPost") Post post) {
        return "timeline";
    }
    @GetMapping(value = "/filthy")
    public String filthy() {
        return "filthy";
    }

    @GetMapping(value = "/users_all")
    public String users_all() {
        return "users_all";
    }

    @GetMapping(value = "/user_claims")
    public String user_claims() {
        return "user_claims";
    }

    @GetMapping(value = "/filthy_words")
    public String filthy_words() {
        return "filthy_words";
    }

    @GetMapping(value = "/follow")
    public String follow() {
        return "follow";
    }

    @GetMapping(value = "/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping(value = "/user_profile")
    public String user_profile() {
        return "user_profile";
    }

    @GetMapping(value = "/claim")
    public String claim() {
        return "claim";
    }

    @GetMapping("/who-to-follow")
    public @ResponseBody
    List<User> whoToFollow(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return followService.whoToFollow(userPrincipal.getUser());
    }

    @GetMapping("/authenticated-user-info")
    public @ResponseBody ProfileUserInfo authenticatedUserInfo(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        User user = userPrincipal.getUser();
        ProfileUserInfo info = new ProfileUserInfo();
        info.setUser(user);
        info.setFollowers(followService.whoFollowsMe(user).size());
        info.setFollowings(followService.whoIFollow(user).size());
        return info;
    }

    @GetMapping("/authenticated-user-follow-info")
    public @ResponseBody ProfileFollowInfo authenticatedUserProfileFollowInfo(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        User user = userPrincipal.getUser();
        ProfileFollowInfo info = new ProfileFollowInfo();
        info.setFollowers(followService.whoFollowsMe(user));
        info.setFollowings(followService.whoIFollow(user));
        return info;
    }
}
