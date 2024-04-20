package com.example.javaproject.Accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccommodationController {

    private final AccommodationTemplate accommodationTemplate;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationTemplate = new AccommodationTemplateImpl(accommodationService);
    }

    @GetMapping("/accommodation")
    public String showAccommodationList(Model model) {
        return accommodationTemplate.showAccommodationList(model);
    }

    @GetMapping("/accommodation/new")
    public String showNewAccommodationForm(Model model) {
        return accommodationTemplate.showNewAccommodationForm(model);
    }

    @PostMapping("/accommodation/save")
    public String saveAccommodation(Accommodation accommodation, RedirectAttributes ra) {
        return accommodationTemplate.saveAccommodation(accommodation, ra);
    }

    @GetMapping("/accommodation/edit/{id}")
    public String showEditAccommodationForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        return accommodationTemplate.showEditAccommodationForm(id, model, ra);
    }

    @PostMapping("/accommodation/update")
    public String updateAccommodation(Accommodation accommodation, RedirectAttributes ra) {
        return accommodationTemplate.updateAccommodation(accommodation, ra);
    }

    @GetMapping("/accommodation/delete/{id}")
    public String deleteAccommodation(@PathVariable("id") Integer id, RedirectAttributes ra) {
        return accommodationTemplate.deleteAccommodation(id, ra);
    }
}
