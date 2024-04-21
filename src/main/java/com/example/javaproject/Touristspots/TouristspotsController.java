package com.example.javaproject.Touristspots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TouristspotsController {

    @Autowired
    private TouristspotsService touristspotsService;

    @GetMapping("/touristspots")
    public String showTouristspotsList(Model model) {
        List<Touristspots> touristspotsList = touristspotsService.listAll();
        model.addAttribute("touristspotsList", touristspotsList);
        return "touristspots"; // Assuming you have a JSP file named "touristspots.jsp"
    }

    @GetMapping("/touristspots/{id}")
    public String showChosenTouristspot(@PathVariable("id") Integer id, Model model) {
        try {
            Touristspots touristspot = touristspotsService.getById(id);
            model.addAttribute("touristspot", touristspot);
            return "touristspot_details";
        } catch (TouristspotsNotFoundException e) {
            model.addAttribute("errorMessage", "Touristspot not found");
            return "touristspot_details";
        }
    }

    @PostMapping("/touristspots/{id}/next")
    public String goToAnotherPage(@PathVariable("id") Integer id, RedirectAttributes ra) {
        ra.addFlashAttribute("message", "Redirected to another page");
        return "redirect:/anotherpage";
    }
}
