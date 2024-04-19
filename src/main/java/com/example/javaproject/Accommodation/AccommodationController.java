package com.example.javaproject.Accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/accommodation/edit/{id}")
    public String showEditAccommodationForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Accommodation accommodation = accommodationService.get(id);
            model.addAttribute("accommodation", accommodation);
            model.addAttribute("pageTitle", "Edit Accommodation (ID: " + id + ")");
            return "accommodation_form"; // Assuming there's a Thymeleaf template named "accommodation_form.html" for editing accommodation details
        } catch (AccommodationNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/accommodation";
        }
    }

    @PostMapping("/accommodation/update")
    public String updateAccommodation(Accommodation accommodation, RedirectAttributes ra) {
        accommodationService.save(accommodation); // Assuming save method handles both insert and update based on the presence of ID
        ra.addFlashAttribute("message", "The accommodation details have been updated successfully.");
        return "redirect:/accommodation";
    }

    @GetMapping("/accommodation/delete/{id}")
    public String deleteAccommodation(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            accommodationService.delete(id);
            ra.addFlashAttribute("message", "The accommodation ID " + id + " has been deleted.");
        } catch (AccommodationNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/accommodation";
    }
}
