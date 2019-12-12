package edu.mum.ea.controllers;

import edu.mum.ea.models.Advert;
import edu.mum.ea.services.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
                         RedirectAttributes redirectAttributes) {
        System.out.println(advert);
        if (!bindingResult.hasErrors()) {
            advert = (Advert) advertService.save(advert);
            redirectAttributes.addFlashAttribute("advert", advert);
            return "redirect:/dashboard";
        }
        return "dashboard";
    }
}
