package com.example.javaproject.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransportController {

    @Autowired
    private TransportService transportService;

    @GetMapping("/transport")
    public String showTransportList(Model model) {
        List<Transport> listTransport = transportService.listAll();
        model.addAttribute("listTransport", listTransport);
        return "transport"; // Assuming you have a Thymeleaf template named "transport.html"
    }

    // Inside your controller method that handles rendering the transport form
    @GetMapping("/transport/new")
    public String showNewTransportForm(Model model) {
        Transport transport = new Transport(); // Create a new Transport object
        model.addAttribute("transport", transport); // Add the transport object to the model
        model.addAttribute("pageTitle", "Add New Transport"); // Add any additional attributes needed
        return "transport_form"; // Return the name of the template
    }

    @PostMapping("/transport/save")
    public String saveTransport(Transport transport, Model model) {
        transportService.save(transport);
        return "redirect:/transport";
    }

    @GetMapping("/transport/edit/{id}")
    public String showEditTransportForm(@PathVariable("id") Integer id, Model model) {
        try {
            Transport transport = transportService.get(id);
            model.addAttribute("transport", transport);
            model.addAttribute("pageTitle", "Edit Transport (ID: " + id + ")");
            return "transport_form"; // Assuming there's a Thymeleaf template named "transport_form.html" for editing transport details
        } catch (TransportNotFoundException e) {
            model.addAttribute("message", e.getMessage());
            return "redirect:/transport";
        }
    }

    @PostMapping("/transport/update")
    public String updateTransport(Transport transport, Model model) {
        transportService.save(transport); // Assuming save method handles both insert and update based on the presence of ID
        return "redirect:/transport";
    }

    @GetMapping("/transport/delete/{id}")
    public String deleteTransport(@PathVariable("id") Integer id, Model model) {
        try {
            transportService.delete(id);
            return "redirect:/transport";
        } catch (TransportNotFoundException e) {
            model.addAttribute("message", e.getMessage());
            return "redirect:/transport";
        }
    }

    @GetMapping("/tripSummary/transport")
    public String redirectToTripSummary(@RequestParam("id") Integer transportId) {
        // Assuming the tripSummary.html Thymeleaf template exists and accepts transport ID as a parameter
        return "redirect:/tripSummary/transport?id=" + transportId;
    }
}
