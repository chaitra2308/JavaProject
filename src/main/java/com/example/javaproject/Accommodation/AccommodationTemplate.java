package com.example.javaproject.Accommodation;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class AccommodationTemplate {

    protected AccommodationService accommodationService;

    public AccommodationTemplate(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    public abstract String showAccommodationList(Model model);

    public abstract String showNewAccommodationForm(Model model);

    public abstract String saveAccommodation(Accommodation accommodation, RedirectAttributes ra);

    public abstract String showEditAccommodationForm(Integer id, Model model, RedirectAttributes ra);

    public abstract String updateAccommodation(Accommodation accommodation, RedirectAttributes ra);

    public abstract String deleteAccommodation(Integer id, RedirectAttributes ra);
}
