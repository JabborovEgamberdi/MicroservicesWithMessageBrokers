package uz.pdp.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.clients.fraud.ApiResponse.FraudCheckResponse;

@FeignClient(value = "fraud", path = "api/v1/fraud-check")
public interface FraudClient {

    @GetMapping(path = "/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID);

}
