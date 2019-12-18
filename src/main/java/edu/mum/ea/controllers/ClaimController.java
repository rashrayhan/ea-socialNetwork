package edu.mum.ea.controllers;

import edu.mum.ea.models.AccountStatus;
import edu.mum.ea.models.Claim;
import edu.mum.ea.models.User;
import edu.mum.ea.services.ClaimService;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClaimController {

    private ClaimService claimService;
    private UserService userService;

    @Autowired
    public ClaimController(ClaimService claimService, UserService userService) {
        this.claimService = claimService;
        this.userService = userService;
    }

    @GetMapping(value = "/user_claims")
    public String user_claims(@ModelAttribute("claim") Claim claim, Model model) {
        model.addAttribute("claims", claimService.findAll());
        return "user_claims";
    }

    @GetMapping(value="/user_claims/unblock/{userId}")
    public String unblock(@PathVariable("userId") Long userId){
        User user = userService.findById(userId);
        user.setAccountStatus(AccountStatus.Active);
        userService.update(user);

        return "redirect:/user_claims";
    }

    @GetMapping(value="/user_claims/delete/{userId}")
    public String delete(@PathVariable("userId") Long userId){
        User user = userService.findById(userId);
        user.setAccountStatus(AccountStatus.Deleted);
        userService.update(user);

        return "redirect:/user_claims";
    }
}
