package com.viniciuscastro.hrpayroll.controllers;

import com.viniciuscastro.hrpayroll.entities.Payment;
import com.viniciuscastro.hrpayroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    private static final String PAYMENT_FALLBACK = "paymentFallback";
    private PaymentService service;

    @GetMapping("{workerId}/days/{workedDays}")
    @CircuitBreaker(name = PAYMENT_FALLBACK, fallbackMethod = "getPaymentAlternative")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer workerId, @PathVariable Integer workedDays) {
        Payment payment = service.getPayment(workerId, workedDays);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Integer workerId, Integer dias, Throwable throwable) {
        Payment payment = new Payment("Bran", 400.0, dias);
        return ResponseEntity.ok(payment);
    }
}
