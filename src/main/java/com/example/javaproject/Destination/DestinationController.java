package com.example.javaproject.Destination;

import com.example.javaproject.Destination.Destination.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/destination")
    public String showDestinationList(Model model) {
        List<Destination> listDestination = destinationService.listAll();
        model.addAttribute("listDestination", listDestination);
        return "destination"; // Assuming you have a JSP file named "destination.jsp"
    }

    @GetMapping("/destination/{id}")
    public String showChosenDestination(@PathVariable("id") Integer id, Model model) {
        try {
            Destination destination = destinationService.getById(id);
            model.addAttribute("destination", destination);
        } catch (DestinationNotFoundException e) {
            model.addAttribute("errorMessage", "Destination not found");
        }
        return "destination_details";
    }

    @PostMapping("/destination/{id}/next")
    public String goToTouristSpots(@PathVariable("id") Integer id, RedirectAttributes ra) {
        ra.addFlashAttribute("message", "Destination chosen");
        return "redirect:/touristspots";
    }

    // Helper method to create Destination using Builder pattern
    private Destination createDestination(Integer id, String destName, byte[] picture, String text) {
        return new Destination.Builder()
                .withId(id)
                .withDestName(destName)
                .withPicture(picture)
                .withText(text)
                .build();
    }
}
