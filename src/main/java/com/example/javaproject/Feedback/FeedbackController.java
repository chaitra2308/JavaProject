package com.example.javaproject.Feedback;

import com.example.javaproject.Feedback.Feedback;
import com.example.javaproject.Feedback.FeedbackNotFoundException;
import com.example.javaproject.Feedback.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String showFeedbackList(Model model) {
        List<Feedback> listFeedback = feedbackService.listAll();
        model.addAttribute("listFeedback", listFeedback);
        return "feedback"; // Assuming you have a JSP file named "feedback.jsp"
    }

    @GetMapping("/feedback/new")
    public String showNewFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("pageTitle", "Add New Feedback");
        return "feedback_form";
    }

    @PostMapping("/feedback/save")
    public String saveFeedback(Feedback feedback, RedirectAttributes ra){
        feedbackService.save(feedback);
        ra.addFlashAttribute("message", "Feedback has been successfully added");
        return "redirect:/feedback";
    }

    @GetMapping("/feedback/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Feedback feedback = feedbackService.get(id);
            model.addAttribute("feedback", feedback);
            model.addAttribute("pageTitle", "Edit Feedback (ID: " + id + ")");
            return "feedback_form"; // Assuming there's a JSP file named "feedback_form.jsp" for editing feedback details
        } catch (FeedbackNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/feedback";
        }
    }

    @PostMapping("/feedback/update")
    public String updateFeedback(Feedback feedback, RedirectAttributes ra) {
        feedbackService.save(feedback); // Assuming save method handles both insert and update based on the presence of ID
        ra.addFlashAttribute("message", "The feedback details have been updated successfully.");
        return "redirect:/feedback";
    }

    @GetMapping("/feedback/delete/{id}")
    public String deleteFeedback(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            feedbackService.delete(id);
            ra.addFlashAttribute("message", "The feedback ID " + id + " has been deleted.");
        } catch (FeedbackNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/feedback";
    }

}
