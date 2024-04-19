package com.example.javaproject.Accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    @GetMapping("/accommodation")
    public String showAccommodationList(Model model) {
        List<Accommodation> listAccommodation = accommodationService.listAll();
        model.addAttribute("listAccommodation", listAccommodation);
        return "accommodation"; // Assuming you have a Thymeleaf template named "accommodation.html"
    }

    @GetMapping("/accommodation/new")
    public String showNewAccommodationForm(Model model) {
        model.addAttribute("accommodation", new Accommodation());
        model.addAttribute("pageTitle", "Add New Accommodation");
        return "accommodation_form";
    }

    @PostMapping("/accommodation/save")
    public String saveAccommodation(Accommodation accommodation, RedirectAttributes ra){
        accommodationService.save(accommodation);
        ra.addFlashAttribute("message", "Accommodation has been successfully added");
        return "redirect:/accommodation";
    }

    // Other methods for editing, updating, and deleting accommodations can be similar to FeedbackController
}

