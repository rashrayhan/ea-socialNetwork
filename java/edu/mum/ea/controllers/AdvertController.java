package edu.mum.ea.controllers;

import edu.mum.ea.models.Advert;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AdvertController {

    AdvertService advertService;

    @Autowired
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping(value = "/dashboard")
    public String advert(@Valid @ModelAttribute("advert") Advert advert, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        if (!bindingResult.hasErrors()) {
            advert.setUser(userPrincipal.getUser());
            advert = advertService.save(advert);
            redirectAttributes.addFlashAttribute("advert", advert);
            return "redirect:/dashboard";
        }

        return "dashboard";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(@ModelAttribute("advert") Advert advert, Model model) {
        model.addAttribute("adverts", advertService.findAll());
        return "dashboard";
    }


}
