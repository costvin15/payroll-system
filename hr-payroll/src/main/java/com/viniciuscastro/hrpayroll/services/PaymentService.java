package com.viniciuscastro.hrpayroll.services;

import com.viniciuscastro.hrpayroll.entities.Payment;
import com.viniciuscastro.hrpayroll.entities.Worker;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {
    @NonNull
    private RestTemplate restTemplate;
    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(long workerId, int workedDays) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        String url = workerHost + "/workers/{id}";
        Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDaily_Income(), workedDays);
    }
}
