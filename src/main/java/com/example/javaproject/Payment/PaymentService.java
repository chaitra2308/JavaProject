package com.example.javaproject.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Iterable<Payment> listAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}
