package com.viniciuscastro.hrpayroll.controllers;

import com.viniciuscastro.hrpayroll.entities.Payment;
import com.viniciuscastro.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
@AllArgsConstructor
public class PaymentController {
    private PaymentService service;

    @GetMapping("{workerId}/days/{workedDays}")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer workerId, @PathVariable Integer workedDays) {
        Payment payment = service.getPayment(workerId, workedDays);
        return ResponseEntity.ok(payment);
    }
}
