package com.example.javaproject.TripSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TripSummaryController {

    @Autowired
    private final TripSummaryRepository tripSummaryRepository;
    private TripSummaryService tripSummaryService;
    @Autowired
    public TripSummaryController(TripSummaryRepository tripSummaryRepository) {
        this.tripSummaryRepository = tripSummaryRepository;
    }

    @GetMapping("/tripSummary")
    public String getAllTripSummaries(Model model) {
        model.addAttribute("listTripSummaries", tripSummaryRepository.findAllWithTouristSpots());
        model.addAttribute("listTripSummaries", tripSummaryRepository.findAllWithAccommodations());
        model.addAttribute("listTripSummaries", tripSummaryRepository.findAllWithModeOfTransport());
        return "tripSummary"; // Assuming your HTML file is named tripSummaries.html
    }
    /*
    @GetMapping("/tripSummary")
    public String showTripSummaryList(Model model) {
        List<TripSummary> listTripSummaries = tripSummaryService.listAll();
        model.addAttribute("listTripSummaries", listTripSummaries);
        return "tripSummary"; // Assuming you have a JSP file named "tripSummary.jsp"
    }*/

    @GetMapping("/tripSummary/new")
    public String showNewTripSummaryForm(Model model) {
        model.addAttribute("tripSummary", new TripSummary());
        model.addAttribute("pageTitle", "Add New Trip Summary");
        return "tripSummary_form";
    }

    @PostMapping("/tripSummary/save")
    public String saveTripSummary(TripSummary tripSummary, RedirectAttributes ra){
        tripSummaryService.save(tripSummary);
        ra.addFlashAttribute("message", "Trip summary has been successfully added");
        return "redirect:/tripSummary";
    }

    @GetMapping("/tripSummary/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            TripSummary tripSummary = tripSummaryService.get(id);
            model.addAttribute("tripSummary", tripSummary);
            model.addAttribute("pageTitle", "Edit Trip Summary (ID: " + id + ")");
            return "tripSummary_form"; // Assuming there's a JSP file named "tripSummary_form.jsp" for editing trip summary details
        } catch (TripSummaryNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/tripSummary";
        }
    }

    @PostMapping("/tripSummary/update")
    public String updateTripSummary(TripSummary tripSummary, RedirectAttributes ra) {
        tripSummaryService.save(tripSummary); // Assuming save method handles both insert and update based on the presence of ID
        ra.addFlashAttribute("message", "The trip summary details have been updated successfully.");
        return "redirect:/tripSummary";
    }

    @GetMapping("/tripSummary/delete/{id}")
    public String deleteTripSummary(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            tripSummaryService.delete(id);
            ra.addFlashAttribute("message", "The trip summary ID " + id + " has been deleted.");
        } catch (TripSummaryNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/tripSummary";
    }

}
