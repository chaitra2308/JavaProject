package com.example.javaproject.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public String showPayments(Model model) {
        model.addAttribute("payments", paymentService.listAllPayments());
        return "payments";
    }

    @GetMapping("/payments/new")
    public String showPaymentForm(Model model) {
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "payment_form";
    }

    @PostMapping("/payments/save")
    public String savePayment(@ModelAttribute("payment") Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/payments/edit/{id}")
    public String editPayment(@PathVariable Integer id, Model model) {
        model.addAttribute("payment", paymentService.getPayment(id));
        return "payment_form";
    }

    @GetMapping("/payments/delete/{id}")
    public String deletePayment(@PathVariable Integer id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }
}
