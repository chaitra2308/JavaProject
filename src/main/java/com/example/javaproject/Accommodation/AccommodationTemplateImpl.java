package com.example.javaproject.Accommodation;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class AccommodationTemplateImpl extends AccommodationTemplate {

    public AccommodationTemplateImpl(AccommodationService accommodationService) {
        super(accommodationService);
    }

    @Override
    public String showAccommodationList(Model model) {
        model.addAttribute("listAccommodation", accommodationService.listAll());
        return "accommodation"; // Assuming you have a Thymeleaf template named "accommodation.html"
    }

    @Override
    public String showNewAccommodationForm(Model model) {
        model.addAttribute("accommodation", new Accommodation());
        model.addAttribute("pageTitle", "Add New Accommodation");
        return "accommodation_form";
    }

    @Override
    public String saveAccommodation(Accommodation accommodation, RedirectAttributes ra) {
        accommodationService.save(accommodation);
        ra.addFlashAttribute("message", "Accommodation has been successfully added");
        return "redirect:/accommodation";
    }

    @Override
    public String showEditAccommodationForm(Integer id, Model model, RedirectAttributes ra) {
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

    @Override
    public String updateAccommodation(Accommodation accommodation, RedirectAttributes ra) {
        accommodationService.save(accommodation); // Assuming save method handles both insert and update based on the presence of ID
        ra.addFlashAttribute("message", "The accommodation details have been updated successfully.");
        return "redirect:/accommodation";
    }

    @Override
    public String deleteAccommodation(Integer id, RedirectAttributes ra) {
        try {
            accommodationService.delete(id);
            ra.addFlashAttribute("message", "The accommodation ID " + id + " has been deleted.");
        } catch (AccommodationNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/accommodation";
    }
}
