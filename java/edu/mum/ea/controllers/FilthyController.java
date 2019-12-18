package edu.mum.ea.controllers;

import edu.mum.ea.models.Advert;
import edu.mum.ea.models.FilthyWord;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.services.AdvertService;
import edu.mum.ea.services.FilthyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FilthyController {

    FilthyService filthyService;

    @Autowired
    public FilthyController(FilthyService filthyService) {
        this.filthyService = filthyService;
    }

    @GetMapping(value = "/filthy_words")
    public String filthy_words(@ModelAttribute("filthyWord") FilthyWord filthyWord, Model model) {
        model.addAttribute("filthy_words", filthyService.findAll());
        return "filthy_words";
    }

    @GetMapping(value="filthy_words/delete/{filthyWordId}")
    public String delete(@PathVariable("filthyWordId") Long filthyWordId){
        filthyService.delete(filthyService.findById(filthyWordId));
        return "redirect:/filthy_words";
    }

    @PostMapping(value = "/filthy_words")
    public String advert(@Valid @ModelAttribute("filthyWord") FilthyWord filthyWord, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            filthyWord = filthyService.save(filthyWord);
            redirectAttributes.addFlashAttribute("filthywords", filthyWord);
            return "redirect:/filthy_words";
        }

        return "filthy_words";
    }
}
