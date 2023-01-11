package com.viniciuscastro.hrpayroll.services;

import com.viniciuscastro.hrpayroll.entities.Payment;
import com.viniciuscastro.hrpayroll.entities.Worker;
import com.viniciuscastro.hrpayroll.feignclients.WorkerFeignClient;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PaymentService {
    @NonNull
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int workedDays) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDaily_Income(), workedDays);
    }
}
