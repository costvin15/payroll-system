package com.viniciuscastro.hrpayroll.services;

import com.viniciuscastro.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(long workerId, int workedDays) {
        return new Payment("Bob ", 200.0, workedDays);
    }
}
